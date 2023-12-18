package com.example.services

import com.example.entities.Driver
import com.example.entities.Location

interface ILocationService {

    suspend fun getAllLocations(command : GetAllLocationsCommand) : List<Location>
    suspend fun getLocationById(command : GetLocationByIdCommand) : Location?
    suspend fun createLocation(command : CreateLocationCommand) : Location
    suspend fun updateLocation(command : UpdateLocationCommand) : Location?
    suspend fun deleteLocation(command : DeleteLocationCommand)


}