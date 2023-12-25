package com.example.controllers

import com.example.commands.GetNextIdCommand
import com.example.repositories.inMemory.RoutesVehicleRepository
import com.example.services.RouteVehicleService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// must be handled with dependency injection
var routeVehicleRepository = RoutesVehicleRepository()
var routeVehicleService = RouteVehicleService(routeVehicleRepository)

fun Route.addRouteVehicleRoutes() {

    route("api/v1/routesVehicle") {
            // POST request to get the next ID
            post("/nextId") {
                val command = GetNextIdCommand()
                val routesVehicleNextId = routeVehicleRepository.getNextId()

                call.respond(routesVehicleNextId)

            }

    }

}