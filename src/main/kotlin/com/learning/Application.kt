package com.learning

import io.ktor.server.application.Application
import com.learning.plugins.configureRouting
import com.learning.plugins.configureSerialization

fun main(args: Array<String>): Unit =
  io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
  configureRouting()
  configureSerialization()
}
