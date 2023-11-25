package com.example.controllers

import com.example.commands.CreateVehicleCommand
import com.example.commands.GetAllVehicleCommand
import com.example.dtos.extensions.toDto
import com.example.dtos.requests.CreateVehicleDto
import com.example.repositories.inMemory.VehicleRepository
import com.example.services.VehicleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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

        post {
            val dto = call.receive<CreateVehicleDto>()
            val command = CreateVehicleCommand(dto.code, dto.name, dto.type, dto.start_year_of_use,dto.url_image)
            val vehicle = vehicleService.createVehicle(command)
            val orderDto = vehicle.toDto()

            call.respond(HttpStatusCode.Created, orderDto)
        }

    }
}