package com.example.services

import com.example.commands.CreateDriverDetailsCommand
import com.example.commands.GetAllDriverDetailsCommand

import com.example.entities.DriverDetails

interface IDriverDetailService {
    suspend fun getAllDriverDetails(command : GetAllDriverDetailsCommand) : List<DriverDetails>
    suspend fun createDriverDetails(command: CreateDriverDetailsCommand) : DriverDetails
}