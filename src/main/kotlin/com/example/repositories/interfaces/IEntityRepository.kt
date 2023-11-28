package com.example.repositories.interfaces

import com.example.entities.Account
import com.example.entities.Order
import com.example.entities.Student
import com.example.entities.Vehicle

interface IEntityRepository<TEntity>{
    suspend fun getAll() : List<TEntity>
    suspend fun findById(id: String) : TEntity?
    suspend fun find(predicate: (TEntity) -> Boolean) : TEntity?
    suspend fun insert(entity : TEntity)
    suspend fun delete(id: String)
    suspend fun replace(item : TEntity)

}

interface ILoginRepository<TEntity>{
    suspend fun findByUsernameAndPassword(username: String, password: String): Boolean
}

interface IOrderRepository: IEntityRepository<Order>
interface IStudentRepository: IEntityRepository<Student>
interface IVehicleRepository: IEntityRepository<Vehicle>
interface IAccountRepository: ILoginRepository<Account>