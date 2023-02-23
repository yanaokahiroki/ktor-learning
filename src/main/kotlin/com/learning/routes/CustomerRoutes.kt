package com.learning.routes

import com.learning.models.customerStorage
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
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
  }
}
