package com.example.repositories.interfaces

import com.example.entities.Order
import com.example.entities.Student

interface IEntityRepository<TEntity>{
    suspend fun getAll() : List<TEntity>
    suspend fun findById(id: String) : TEntity?
    suspend fun find(predicate: (TEntity) -> Boolean) : TEntity?
    suspend fun insert(entity : TEntity)
    suspend fun delete(id: String)
    suspend fun replace(item : TEntity)
}

interface IOrderRepository : IEntityRepository<Order>
interface IStudentRepository : IEntityRepository<Student>