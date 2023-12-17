package com.example.services

import com.example.commands.*
import com.example.entities.Vehicle

interface IVehicleService {
    suspend fun getAllVehicles(command : GetAllVehicleCommand): List<Vehicle>
    suspend fun createVehicle(command: CreateVehicleCommand): Vehicle
    suspend fun getVehicleById(command: GetVehicleByIdCommand): Vehicle?
    suspend fun deleteVehicle(command: DeleteVehicleCommand)
    suspend fun getAllVehicleByType(command: GetAllVehicleByTypeCommand): List<Vehicle>

}