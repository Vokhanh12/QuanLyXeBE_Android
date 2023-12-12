package com.example.repositories.inMemory

import AdvancedRepository
import com.example.entities.DriverDetail
import com.example.repositories.interfaces.IDriverDetailRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.transactions.transaction


object DriverDetails: StringIdTable() {
    val routeId = varchar("route_id",20)
    val driverId = varchar("driver_id",5)
    val vehicleId = varchar("vehicle_id",20)
    val startTime = datetime("start_time")
    val endTime = datetime("end_time")
}

    class DriverDetailsRepository(driverIdProvider: (DriverDetail) -> String, vehicleIdProvider: (DriverDetail) -> String)
    : AdvancedRepository<DriverDetail>(driverIdProvider, vehicleIdProvider), IDriverDetailRepository {

        override suspend fun insert(entity: DriverDetail) {
            transaction {
                val id = DriverDetails
                    .insertAndGetId {
                        it[routeId] = entity.routeId
                        it[driverId] = entity.driverId
                        it[vehicleId] = entity.vehicleId
                        it[startTime] = entity.startTime
                        it[endTime] = entity.endTime
                    }
            }
        }


    private fun rowToDriverDetail(row: ResultRow): DriverDetail {
        return DriverDetail(
            row[DriverDetails.routeId],
            row[DriverDetails.driverId],
            row[DriverDetails.vehicleId]
        ).apply{
            startTime = row[DriverDetails.startTime]
            endTime = row[DriverDetails.endTime]
        }
    }
}
