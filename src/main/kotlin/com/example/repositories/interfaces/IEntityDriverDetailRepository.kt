package com.example.repositories.interfaces

import com.example.entities.DriverDetail

interface IEntityDriverDetailRepository<TEntity>: IEntityRepository<TEntity>{
    suspend fun findDriverNameByDriverDetailsId(driverDetailsId: String): String?
    suspend fun findInRangeOfForeignKey(startKey: String, endKey: String)
}
interface IDriverDetailRepository: IEntityDriverDetailRepository<DriverDetail>