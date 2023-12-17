package com.example.services

import com.example.commands.*
import com.example.entities.Vehicle
import com.example.repositories.inMemory.VehicleRepository
import com.microsoft.windowsazure.exception.ServiceException

class VehicleService(private val vehicleRepository: VehicleRepository): IVehicleService {
    override suspend fun getAllVehicles(command: GetAllVehicleCommand): List<Vehicle> {
        try {
            return vehicleRepository.getAll()
        } catch (e: Exception) {
            // Handle the exception (e.g., log it) and decide how to proceed
            throw ServiceException("Error fetching vehicles", e)
        }
    }

    override suspend fun createVehicle(command: CreateVehicleCommand): Vehicle {
        try {
            val vehicle = command.toEntity()
            vehicleRepository.insert(vehicle)
            return vehicle
        } catch (e: Exception) {
            // Handle the exception (e.g., log it) and decide how to proceed
            throw ServiceException("Error creating vehicle", e)
        }
    }

    override suspend fun getVehicleById(command: GetVehicleByIdCommand): Vehicle? {
        try {
            return vehicleRepository.findById(command.vehicleId)
        } catch (e: Exception) {
            // Handle the exception (e.g., log it) and decide how to proceed
            throw ServiceException("Error fetching vehicle by ID", e)
        }
    }

    override suspend fun deleteVehicle(command: DeleteVehicleCommand) {
        try {
            vehicleRepository.delete(command.vehicleId)
        } catch (e: Exception) {
            // Handle the exception (e.g., log it) and decide how to proceed
            throw ServiceException("Error deleting vehicle", e)
        }
    }

    override suspend fun getAllVehicleByType(command: GetAllVehicleByTypeCommand): List<Vehicle> {
        try {
            return vehicleRepository.getAllByType(command.vehicleType)
        } catch (e: Exception) {
            // Handle the exception (e.g., log it) and decide how to proceed
            throw ServiceException("Error fetching vehicles", e)
        }
    }

}
