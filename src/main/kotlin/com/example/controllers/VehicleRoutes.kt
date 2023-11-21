package com.example.controllers

import com.example.commands.GetAllOrdersCommand
import com.example.commands.GetAllVehicleCommand
import com.example.dtos.extensions.toDto
import com.example.repositories.inMemory.VehicleRepository
import com.example.services.VehicleService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

var vehicleRepository = VehicleRepository()
var vehicleService = VehicleService(vehicleRepository)
fun Route.addVehicleRoutes(){
    route("api/v1/vehicles") {
        get {
            val command = GetAllVehicleCommand()
            val vehicles = vehicleService.getAllVehicles(command)
            val vehicleDto = vehicles.map { it.toDto() }
            call.respond(vehicleDto)
        }

    }
}