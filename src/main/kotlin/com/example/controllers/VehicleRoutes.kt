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
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

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
            try {
                // Xử lý trường hợp CreateVehicleDto
                val contentType = call.request.contentType()
                if (contentType.match(ContentType.Application.Json)) {
                    val dto = call.receive<CreateVehicleDto>()
                    val command = CreateVehicleCommand(dto.id,dto.name, dto.type, dto.startYearOfUse,dto.status,dto.urlImage)
                    val vehicle = vehicleService.createVehicle(command)
                    val vehicleDto = vehicle.toDto()

                    call.respond(HttpStatusCode.Created, vehicleDto)

                } else {
                    call.respond(HttpStatusCode.BadRequest, "Unsupported content type")
                }

                // Xử lý trường hợp tải lên tệp tin
                call.receiveMultipart().forEachPart { part ->
                    when (part) {
                        is PartData.FileItem -> {
                            // Xử lý tệp tin
                            val fileName = part.originalFileName ?: "unknown"
                            val filePath = "./src/main/resources/static/vehicle/$fileName"
                            val file = File(filePath)

                            // An toàn với đường dẫn
                            if (file.parentFile.exists() || file.parentFile.mkdirs()) {
                                part.streamProvider().use { input ->
                                    file.outputStream().buffered().use { output ->
                                        input.copyTo(output)
                                    }
                                }
                                call.respondText("Upload successful: $filePath", status = HttpStatusCode.OK)
                            } else {
                                call.respondText("Cannot create directory", status = HttpStatusCode.InternalServerError)
                            }
                        }
                        is PartData.FormItem -> {
                            // Xử lý các loại FormItem nếu cần thiết
                            call.respondText("Form item received: ${part.value}", status = HttpStatusCode.OK)
                        }
                        else -> {
                            // Xử lý các loại khác nếu cần thiết
                            call.respondText("Unsupported part type", status = HttpStatusCode.BadRequest)
                        }
                    }
                }


            } catch (e: Exception) {
                // Xử lý lỗi chung và phản hồi chi tiết
                call.respondText("Error: ${e.localizedMessage}", status = HttpStatusCode.InternalServerError)
            }
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

