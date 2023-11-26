package com.example.services

import com.example.commands.*
import com.example.entities.Vehicle
import com.example.repositories.inMemory.VehicleRepository

class VehicleService(private val vehicleRepository: VehicleRepository): IVehicleService {
    override suspend fun getAllVehicles(command: GetAllVehicleCommand): List<Vehicle> {
        return vehicleRepository.getAll()
    }

    override suspend fun createVehicle(command: CreateVehicleCommand): Vehicle {
        val vehicle = command.toEntity()
        vehicleRepository.insert(vehicle)
        return vehicle
    }

    override suspend fun getVehicleById(command: GetVehicleByIdCommand): Vehicle? {
        return vehicleRepository.findById(command.vehicleId)
    }

    override suspend fun deleteVehicle(command: DeleteVehicleCommand) {
        vehicleRepository.delete(command.vehicleId)
    }

}