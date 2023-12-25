package com.example.services

import com.example.commands.*
import com.example.entities.RouteVehicle
import com.example.repositories.interfaces.IRouteVehicleRepository

class RouteVehicleService(private val routeVehicleRepository: IRouteVehicleRepository): IRouteVehicleService {
    override suspend fun getAllRouteVehicle(command: GetAllRoutesVehicleCommand): List<RouteVehicle> {
        TODO("Not yet implemented")
    }

    override suspend fun createRouteVehicle(command: CreateRouteVehicleCommand): RouteVehicle {
        TODO("Not yet implemented")
    }

    override suspend fun getRouteVehicleById(command: GetRouteVehicleByIdCommand): RouteVehicle? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRouteVehicle(command: DeleteRouteVehicleCommand) {
        TODO("Not yet implemented")
    }

    override suspend fun getNextId(command: GetNextIdCommand): String {
        return routeVehicleRepository.getNextId()
    }

}