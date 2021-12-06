package com.example.plugins

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        route("") {
            get {
                call.respondText("Hello, world!")
            }
            post {
                val parameters = call.receiveParameters()
                val name = parameters["name"].toString()
                call.respondText("Have a nice day, $name!")
            }
        }
    }
}
