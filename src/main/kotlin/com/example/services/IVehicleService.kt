package com.example.services

import com.example.commands.GetAllVehicleCommand
import com.example.entities.Student
import com.example.entities.Vehicle

interface IVehicleService {
    suspend fun getAllVehicles(command : GetAllVehicleCommand) : List<Vehicle>



}