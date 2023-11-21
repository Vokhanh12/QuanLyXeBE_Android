package com.example.services

import com.example.commands.GetAllVehicleCommand
import com.example.entities.Vehicle
import com.example.repositories.inMemory.VehicleRepository

class VehicleService(private val vehicleRepository: VehicleRepository): IVehicleService {
    override suspend fun getAllVehicles(command: GetAllVehicleCommand): List<Vehicle> {
        return vehicleRepository.getAll()
    }

}