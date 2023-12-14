package com.example.services

import com.example.commands.CreateDriverDetailCommand
import com.example.commands.GetAllDriverDetailsCommand
import com.example.commands.toEnity
import com.example.entities.DriverDetail
import com.example.repositories.interfaces.IDriverDetailRepository

class DriverDetailService(private val driverDetailRepository: IDriverDetailRepository): IDriverDetailService {
    override suspend fun getAllDriverDetails(command: GetAllDriverDetailsCommand): List<DriverDetail> {
        return driverDetailRepository.getAll()
    }

    override suspend fun createDriverDetails(command: CreateDriverDetailCommand): DriverDetail {

        val driverDetail = command.toEnity()
        driverDetailRepository.insert(driverDetail)

        return driverDetail
    }
    override suspend fun findDriverNameByDriverDetailsId(driverDetailId: String): String? {

        return  driverDetailRepository.findDriverNameByDriverDetailsId(driverDetailId)

    }


}