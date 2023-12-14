package com.example.controllers

import com.example.commands.CreateDriverDetailCommand
import com.example.commands.GetAllDriverDetailsCommand
import com.example.dtos.extensions.toDto
import com.example.dtos.requests.CreateDriverDetailDto
import com.example.repositories.inMemory.DriverDetailRepository
import com.example.services.DriverDetailService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


var driverDetailRepositorydriverDetail = DriverDetailRepository(
    driverIdProvider = { driverDetail -> driverDetail.driverId },
    vehicleIdProvider = { driverDetail -> driverDetail.vehicleId }
)
var driverDetailService = DriverDetailService(driverDetailRepositorydriverDetail)

fun Route.addDriverDetailRoute() {

    route("api/v1/DriverDetails"){

        get{

            val command = GetAllDriverDetailsCommand()
            val driverDetails = driverDetailService.getAllDriverDetails(command)
            val driverDetailsDto = driverDetails.map { it.toDto() }
            call.respond(driverDetailsDto)

        }

        post {

            val dto = call.receive<CreateDriverDetailDto>()

            val command = CreateDriverDetailCommand(dto.routeId, dto.driverId, dto.vehicleId, dto.startTime, dto.endTime)
            val driverDetail = driverDetailService.createDriverDetails(command)
            val driverDetailDto = driverDetail.toDto()

            call.respond(HttpStatusCode.Created, driverDetailDto)
        }

        get("{driverId}") {
            val driverId = call.parameters["driverId"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Missing driverId parameter")

            // Gọi hàm findVehicleNameByDriverDetailsId từ DriverDetailRepository
            val driverName = driverDetailService.findDriverNameByDriverDetailsId(driverId)

            if (driverName != null) {
                call.respond(mapOf("driverId" to driverId, "vehicleName" to driverName))
            } else {
                call.respond(HttpStatusCode.NotFound, "VehicleName not found for driverId: $driverId")
            }
        }




    }
}