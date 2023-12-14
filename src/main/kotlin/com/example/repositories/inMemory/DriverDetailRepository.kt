package com.example.repositories.inMemory

import BaseDriverDetailRepository
import com.example.entities.DriverDetail
import com.example.repositories.interfaces.IDriverDetailRepository
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


object DriverDetails: IntIdTable() {
    val routeId = varchar("route_id",20)
    val driverId = reference("driver_id",Drivers)
    val vehicleId = varchar("vehicle_id",20)
    val startTime = datetime("start_time")
    val endTime = datetime("end_time")
}

    class DriverDetailRepository(
        driverIdProvider: (DriverDetail) -> String, vehicleIdProvider: (DriverDetail) -> String)
    : BaseDriverDetailRepository<DriverDetail>(driverIdProvider, vehicleIdProvider), IDriverDetailRepository {

        override suspend fun getAll(): List<DriverDetail> {
            return transaction {
                DriverDetails.selectAll().map { rowToDriverDetail(it) }
            }
        }

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

        override suspend fun findDriverNameByDriverDetailsId(driverDetailsId: String): String? {
            return transaction {
                Drivers.innerJoin(DriverDetails)
                    .select { DriverDetails.driverId eq driverDetailsId}
                    .singleOrNull()
                    ?.get(Drivers.name)
            }
        }


    private fun rowToDriverDetail(row: ResultRow): DriverDetail {
        return DriverDetail(
            row[DriverDetails.id].value.toString(),
            row[DriverDetails.routeId],
            row[DriverDetails.driverId].value,
            row[DriverDetails.vehicleId]
        ).apply{
            startTime = row[DriverDetails.startTime]
            endTime = row[DriverDetails.endTime]
        }
    }
}
