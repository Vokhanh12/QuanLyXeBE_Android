package com.example.services

import com.example.commands.CreateVehicleCommand
import com.example.commands.GetAllVehicleCommand
import com.example.entities.Vehicle

interface IVehicleService {
    suspend fun getAllVehicles(command : GetAllVehicleCommand): List<Vehicle>
    suspend fun createVehicle(command: CreateVehicleCommand): Vehicle

}