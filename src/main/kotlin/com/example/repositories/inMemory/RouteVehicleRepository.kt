package com.example.repositories.inMemory

import com.example.entities.RouteVehicle
import com.example.repositories.interfaces.IRouteVehicleRepository
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction


object Routes: StringIdTable() {

    val name = varchar("name", 50)
    val length = decimal("length",3,2)
    val note = varchar("note",100)

}

class RouteVehicleRepository: BaseRepository<RouteVehicle>(), IRouteVehicleRepository {
    override suspend fun getNextId(): String {
        val nextId = transaction {
            SchemaUtils.create(Routes)

            val maxId: String? = Routes.select { Routes.id.like("T%") }
                .orderBy(Routes.id, SortOrder.DESC)
                .limit(1)
                .singleOrNull()?.get(Routes.id)?.value

            val nextNumber: Int = maxId?.let {
                (it.substring(1).toIntOrNull() ?: 0) + 1
            } ?: 1

            "T${nextNumber.toString().padStart(3, '0')}"
        }

        return nextId
    }


}