package com.example.repositories.inMemory

import com.example.entities.Vehicle
import com.example.repositories.interfaces.IVehicleRepository
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

object Vehicles: StringIdTable(){

    val name = varchar("name",50)
    val type = varchar("type",30)
    val start_year_of_use = varchar("start_year_of_use",5)
    val status = varchar("status", length = 5)
    val url_image = varchar("url_image",100)


}


class VehicleRepository() : BaseRepository<Vehicle>(), IVehicleRepository{

    // Base handle
    override suspend fun getAll(): List<Vehicle> {
        return transaction {
            Vehicles.selectAll().map { rowToVehicle(it)}
        }
    }
    override suspend fun insert(entity: Vehicle) {
        transaction {
            val id = Vehicles
                .insertAndGetId {
                    it[id] = entity.id
                    it[name] = entity.name
                    it[type] = entity.type
                    it[start_year_of_use] = entity.start_year_of_use
                    it[status] = entity.status
                    it[url_image] = entity.url_image
                }
        }
    }
    override suspend fun delete(id: String) {
        transaction {
            Vehicles.deleteWhere { Vehicles.id eq id }
        }
    }
    override suspend fun findById(id: String): Vehicle? {
        return transaction {
            Vehicles.select { Vehicles.id eq id }.singleOrNull()?.let { rowToVehicle(it) }
        }
    }

    // Advance handle

    suspend fun getAllByType(type : String): List<Vehicle>{

        return transaction {
            Vehicles.select{ Vehicles.type eq type }.map { rowToVehicle(it) }
        }

    }



    private fun rowToVehicle(row: ResultRow): Vehicle{
        return Vehicle(row[Vehicles.id].value).apply {
            name = row[Vehicles.name]
            type = row[Vehicles.type]
            start_year_of_use = row[Vehicles.start_year_of_use]
            status = row[Vehicles.status]
            url_image = BASE_URL + row[Vehicles.url_image]
        }

    }

}
open class StringIdTable(name: String = "", columnName: String = "id", columnLength: Int = 10) : IdTable<String>(name) {
    override val id: Column<EntityID<String>> = varchar(columnName, columnLength).entityId()
    override val primaryKey by lazy { super.primaryKey ?: PrimaryKey(id, name = "PK_${name}_ID") }

    init {
        if (this !is Table) {
            throw IllegalStateException("$this must have a single column as EntityID and be a subclass of org.jetbrains.exposed.sql.Table")
        }
    }
}
