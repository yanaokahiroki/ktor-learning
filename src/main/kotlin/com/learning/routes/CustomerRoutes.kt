package com.learning.routes

import com.learning.models.Customer
import com.learning.models.customerStorage
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.*

fun Route.customerRouting() {
  route("/customer") {
    get {
      if (customerStorage.isEmpty()) {
        return@get call.respondText("No Customer found", status = HttpStatusCode.OK)
      }
      return@get call.respond(customerStorage)
    }
    
    get("{id?}") {
      val id = call.parameters["id"] ?: return@get call.respondText(
        "Missing ID",
        status = HttpStatusCode.BadRequest
      )
      
      val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
        "No Customer found with $id", status = HttpStatusCode.NotFound
      )
      return@get call.respond(customer)
    }
  
    post {
      val customer = call.receive<Customer>()
      customerStorage.add(customer)
      return@post call.respond(customer)
    }
  
    delete("{id?}") {
      val id = call.parameters["id"] ?: return@delete call.respondText(
        "Missing ID",
        status = HttpStatusCode.BadRequest
      )
    
      if (customerStorage.removeIf { it.id == id }) {
        return@delete call.respondText("Customer removed correctly", status = HttpStatusCode.OK)
      }
      return@delete call.respondText("No Customer with $id", status = HttpStatusCode.NotFound)
    }
  }
}
