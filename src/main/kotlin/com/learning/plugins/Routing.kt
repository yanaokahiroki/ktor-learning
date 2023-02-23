package com.learning.plugins

import com.learning.routes.customerRouting
import com.learning.routes.getOrderRoute
import com.learning.routes.listOrdersRoute
import com.learning.routes.totalizeOrderRoute
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
  routing {
    customerRouting()
    listOrdersRoute()
    getOrderRoute()
    totalizeOrderRoute()
  }
}
