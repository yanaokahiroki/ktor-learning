package com.learning.routes

import com.learning.models.orderStorage
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.listOrdersRoute() {
  get("/order") {
    if (orderStorage.isEmpty()) {
      return@get call.respondText("No Order found", status = HttpStatusCode.OK)
    }
    
    return@get call.respond(orderStorage)
  }
}

fun Route.getOrderRoute() {
  get("/order/{id?}") {
    val id =
      call.parameters["id"] ?: return@get call.respondText("Missing ID", status = HttpStatusCode.BadRequest)
    
    val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
      "No Order found with $id",
      status = HttpStatusCode.NotFound
    )
    
    return@get call.respond(order)
  }
}

fun Route.totalizeOrderRoute() {
  get("/order/{id?}/total") {
    val id =
      call.parameters["id"] ?: return@get call.respondText("Missing ID", status = HttpStatusCode.BadRequest)
    
    val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
      "No Order found with $id",
      status = HttpStatusCode.NotFound
    )
    
    val totalAmountOfOrder = order.contents.sumOf { it.amount * it.price }
    
    return@get call.respond(totalAmountOfOrder)
  }
}
