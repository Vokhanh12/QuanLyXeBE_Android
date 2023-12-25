package com.example.repositories.interfaces

import com.example.entities.*

// Interface origin
interface ILoginRepository<TEntity>{
    suspend fun getTypeByUsernameAndPassword(username: String, password: String): String?
}
interface IEntityRepository<TEntity>{
    suspend fun getAll() : List<TEntity>
    suspend fun findById(id: String) : TEntity?
    suspend fun find(predicate: (TEntity) -> Boolean) : TEntity?
    suspend fun insert(entity : TEntity)
    suspend fun delete(id: String)
    suspend fun replace(item : TEntity)

}

// Interface used to extend by Interface origin

interface IOrderRepository: IEntityRepository<Order>
interface IStudentRepository: IEntityRepository<Student>
interface IVehicleRepository: IEntityRepository<Vehicle>
interface IAccountRepository: ILoginRepository<Account>
interface ILocationRepository: IEntityRepository<Location>
interface IDriverRepository: IEntityRepository<Driver>
interface IRouteVehicleRepository: IEntityRepository<RouteVehicle>{
    suspend fun getNextId(): String
}