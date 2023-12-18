package com.example.services

import com.example.commands.*
import com.example.entities.Driver
import com.example.entities.Order

interface IDrvierService {

    suspend fun getAllDrivers(command : GetAllDriversCommand) : List<Driver>
    suspend fun getDriverById(command : GetDriverByIdCommand) : Driver?
    suspend fun createDriver(command : CreateDriverCommand) : Driver
    suspend fun updateDriver(command : UpdateDriverCommand) : Driver?
    suspend fun deleteDriver(command : DeleteDriverCommand)

}