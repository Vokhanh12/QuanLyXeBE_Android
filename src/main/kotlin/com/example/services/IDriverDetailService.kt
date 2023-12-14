package com.example.services

import com.example.commands.CreateDriverDetailCommand
import com.example.commands.GetAllDriverDetailsCommand
import com.example.entities.DriverDetail


interface IDriverDetailService {
    suspend fun getAllDriverDetails(command : GetAllDriverDetailsCommand) : List<DriverDetail>
    suspend fun createDriverDetails(command: CreateDriverDetailCommand) : DriverDetail
    suspend fun findDriverNameByDriverDetailsId(driverDetailId: String): String?
}