package com.example.repositories.inMemory

import com.example.entities.Student
import com.example.entities.Vehicle
import com.example.repositories.interfaces.IEntityRepository
import com.example.repositories.interfaces.IVehicleRepository
import io.ktor.server.util.*
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Vehicles: IntIdTable(){

    val vehicle_id = varchar("vehicle_id",5)
    val vehicle_name = varchar("vehicle_name",50)
    val vehicle_type = varchar("vehicle_type",30)
    val start_year_of_use = varchar("start_year_of_use",5)
    val url_image = varchar("url_image",100)

}


class VehicleRepository: BaseRepository<Vehicle>(), IVehicleRepository{

    override suspend fun getAll(): List<Vehicle> {
        return transaction {
            Vehicles.selectAll().map { rowToVehicle(it)}
        }
    }

    private fun rowToVehicle(row: ResultRow): Vehicle{
        return Vehicle(row[Vehicles.id].value.toString()).apply {
            vehicle_id = row[Vehicles.vehicle_id]
            vehicle_name = row[Vehicles.vehicle_name]
            vehicle_type = row[Vehicles.vehicle_type]
            start_year_of_use = row[Vehicles.start_year_of_use]
            url_image = BASE_URL + row[Vehicles.url_image]
        }

    }

}