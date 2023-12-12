package com.example.services

import com.example.commands.CreateDriverDetailsCommand
import com.example.commands.GetAllDriverDetailsCommand
import com.example.entities.DriverDetails

class DriverDetailsService: IDriverDetailService {
    override suspend fun getAllDriverDetails(command: GetAllDriverDetailsCommand): List<DriverDetails> {
        TODO("Not yet implemented")
    }

    override suspend fun createDriverDetails(command: CreateDriverDetailsCommand): DriverDetails {
        TODO("Not yet implemented")
    }
}