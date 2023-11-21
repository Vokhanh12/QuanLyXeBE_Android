package com.example.plugins

import com.example.controllers.addOrderRoutes
import com.example.controllers.addStudentRoutes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }



        // Static plugin. Try to access `/static/index.html`
        static() {
            resources("static")
        }

    }
}
