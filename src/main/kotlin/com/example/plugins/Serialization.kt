package com.example.plugins

import com.example.controllers.addAccountRoutes
import com.example.controllers.addOrderRoutes
import com.example.controllers.addStudentRoutes
import com.example.controllers.addVehicleRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    routing {

        addAccountRoutes()
        addVehicleRoutes()
        addOrderRoutes()
        addStudentRoutes()

        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }


    }
}
