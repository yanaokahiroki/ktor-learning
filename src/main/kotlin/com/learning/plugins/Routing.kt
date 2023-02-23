package com.learning.plugins

import com.learning.routes.customerRouting
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
  routing {
    customerRouting()
  }
}
