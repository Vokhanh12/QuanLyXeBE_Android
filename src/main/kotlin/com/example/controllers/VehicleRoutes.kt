package com.example.controllers

import com.example.commands.CreateVehicleCommand
import com.example.commands.DeleteVehicleCommand
import com.example.commands.GetAllVehicleCommand
import com.example.commands.GetVehicleByIdCommand
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

        get("{id}"){

            val id = call.parameters["id"]

            if(id == null)
                call.respond(HttpStatusCode.BadRequest)

            val command = GetVehicleByIdCommand(id!!)

            val vehicle = vehicleService.getVehicleById(command)

            if(vehicle == null)
                call.respond(HttpStatusCode.NotFound)

            val vehicleDto = vehicle!!.toDto()
            call.respond(vehicleDto)

        }

        post {
            val dto = call.receive<CreateVehicleDto>()
            val command = CreateVehicleCommand(dto.code, dto.name, dto.type, dto.startYearOfUse,dto.urlImage)
            val vehicle = vehicleService.createVehicle(command)
            val vehicleDto = vehicle.toDto()

            call.respond(HttpStatusCode.Created, vehicleDto)
        }

        delete("{id}") {
            val id = call.parameters["id"]

            if(id == null)
                call.respond(HttpStatusCode.BadRequest)

            val command = GetVehicleByIdCommand(id!!)

            val vehicle = vehicleService.getVehicleById(command)

            if(vehicle == null)
                call.respond(HttpStatusCode.NotFound)

            val deleteCommand = DeleteVehicleCommand(id)

            vehicleService.deleteVehicle(deleteCommand)
            call.respond(HttpStatusCode.NoContent)

        }

    }
}