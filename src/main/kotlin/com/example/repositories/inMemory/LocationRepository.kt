package com.example.repositories.inMemory

import com.example.entities.Location
import com.example.repositories.interfaces.ILocationRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Locations: StringIdTable(){
    val name = varchar("name",50)
    val latitude = decimal("latitude",5,10)
    val longitude = decimal("longitude",5,10)
}

class LocationRepository(): BaseRepository<Location>(),  ILocationRepository{

    override suspend fun getAll(): List<Location> {
        return transaction {
            Locations.selectAll().map { rowToLocation(it) }
        }
    }

    override suspend fun delete(id: String) {
        super.delete(id)
    }

    override suspend fun findById(id: String): Location? {
        return super.findById(id)
    }

    override suspend fun find(predicate: (Location) -> Boolean): Location? {
        return super.find(predicate)
    }

    override suspend fun insert(entity: Location) {
        super.insert(entity)
    }

    override suspend fun replace(item: Location) {
        super.replace(item)
    }

    private fun rowToLocation(row: ResultRow): Location {
        return Location(row[Locations.id].value).apply {
            name = row[Locations.name]
            latitude = row[Locations.latitude]
            longitude = row[Locations.longitude]
        }
    }


}
