package com.example.services

import com.example.commands.*
import com.example.entities.RouteVehicle

interface IRouteVehicleService {
    suspend fun getAllRouteVehicle(command : GetAllRoutesVehicleCommand): List<RouteVehicle>
    suspend fun createRouteVehicle(command: CreateRouteVehicleCommand): RouteVehicle
    suspend fun getRouteVehicleById(command: GetRouteVehicleByIdCommand): RouteVehicle?
    suspend fun deleteRouteVehicle(command: DeleteRouteVehicleCommand)

    // Add properties
    suspend fun getNextId(command: GetNextIdCommand): String

}