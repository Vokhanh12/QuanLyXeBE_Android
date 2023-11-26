package com.example.repositories.inMemory

import com.example.entities.Vehicle
import com.example.repositories.interfaces.IVehicleRepository
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

object Vehicles: IntIdTable(){

    val code = varchar("code",5)
    val name = varchar("name",50)
    val type = varchar("type",30)
    val start_year_of_use = varchar("start_year_of_use",5)
    val url_image = varchar("url_image",100)

}


class VehicleRepository: BaseRepository<Vehicle>(), IVehicleRepository{

    override suspend fun getAll(): List<Vehicle> {
        return transaction {
            Vehicles.selectAll().map { rowToVehicle(it)}
        }
    }

    override suspend fun insert(entity: Vehicle) {
        transaction {
            val id = Vehicles
                .insertAndGetId {
                    it[code] = entity.code
                    it[name] = entity.name
                    it[type] = entity.type
                    it[start_year_of_use] = entity.start_year_of_use
                    it[url_image] = entity.url_image
                }
            entity.id = id.value.toString()
        }
    }

    override suspend fun delete(id: String) {
        transaction {
            Vehicles.deleteWhere { Vehicles.id eq id.toInt() }
        }
    }
    override suspend fun findById(id: String): Vehicle? {
        return transaction {
            Vehicles.select { Vehicles.id eq id.toInt() }.singleOrNull()?.let { rowToVehicle(it) }
        }
    }

    private fun rowToVehicle(row: ResultRow): Vehicle{
        return Vehicle(row[Vehicles.id].value.toString()).apply {
            code = row[Vehicles.code]
            name = row[Vehicles.name]
            type = row[Vehicles.type]
            start_year_of_use = row[Vehicles.start_year_of_use]
            url_image = BASE_URL + row[Vehicles.url_image]
        }

    }

}