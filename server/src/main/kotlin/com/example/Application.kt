package com.example

import com.example.plugins.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.main() {
    install(CORS) {
        anyHost()
    }
    configureRouting()
}
