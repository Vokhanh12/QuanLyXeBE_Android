package com.example.repositories.interfaces

import com.example.entities.DriverDetail

interface IEntityDetailRepository<TEntity>{
    suspend fun getAll(): List<TEntity>
    suspend fun insert(entity: TEntity)
    suspend fun delete(id: String)
    suspend fun replace(item: TEntity)
    suspend fun findVehicleNameByDriverDetailsId(driverDetailsId: String): String?
    suspend fun findInRangeOfForeignKey(startKey: String, endKey: String)
}
interface IDriverDetailRepository: IEntityDetailRepository<DriverDetail>