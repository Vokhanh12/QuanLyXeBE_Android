package com.example.services

import com.example.commands.*
import com.example.entities.Location
import com.example.repositories.inMemory.LocationRepository

class LocationService(private val locationRepository: LocationRepository): ILocationService  {
    override suspend fun getAllLocations(command: GetAllLocationsCommand): List<Location> {
        return locationRepository.getAll()
    }

    override suspend fun getLocationById(command: GetLocationByIdCommand): Location? {
        TODO("Not yet implemented")
    }

    override suspend fun createLocation(command: CreateLocationCommand): Location {
        TODO("Not yet implemented")
    }

    override suspend fun updateLocation(command: UpdateLocationCommand): Location? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLocation(command: DeleteLocationCommand) {
        TODO("Not yet implemented")
    }
}