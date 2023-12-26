package com.example.controllers

import com.example.commands.GetNextIdCommand
import com.example.repositories.inMemory.RouteVehicleRepository
import com.example.services.RouteVehicleService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// must be handled with dependency injection
var routeVehicleRepository = RouteVehicleRepository()
var routeVehicleService = RouteVehicleService(routeVehicleRepository)

fun Route.addRouteVehicleRoutes() {

    route("api/v1/RoutesVehicle") {
            // POST request to get the next ID
            post("/nextId") {

                val command = GetNextIdCommand()

                val routesVehicleNextId = routeVehicleRepository.getNextId()

                call.respond(routesVehicleNextId)

            }

    }

}