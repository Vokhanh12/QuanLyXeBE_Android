package com.example.controllers

import com.example.commands.GetAllLocationsCommand
import com.example.dtos.extensions.toDto
import com.example.repositories.inMemory.LocationRepository
import com.example.services.LocationService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val locationRepository = LocationRepository()
val locationService = LocationService(locationRepository)

fun Route.addLocationRoutes () {

    route("api/v1/locations"){

        get{

            val command = GetAllLocationsCommand()
            val locations = locationService.getAllLocations(command)

            val locationsDto = locations.map { it.toDto() }

            call.respond(locationsDto)

        }

    }

}