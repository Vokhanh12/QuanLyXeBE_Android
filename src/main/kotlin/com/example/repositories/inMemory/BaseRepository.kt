package com.example.repositories.inMemory

import com.example.entities.Entity
import com.example.repositories.interfaces.IEntityRepository

open class BaseRepository<TEntity : Entity>() : IEntityRepository<TEntity> {

    companion object{
        final val BASE_URL = "http://172.20.10.2:8080"
    }

    private var entities = mutableListOf<TEntity>()

    override suspend fun getAll(): List<TEntity> {
        return entities
    }

    override suspend fun findById(id: String): TEntity? {
        return entities.find { it.id == id }
    }

    override suspend fun find(predicate: (TEntity) -> Boolean) : TEntity? {
        return entities.find(predicate)
    }

    override suspend fun delete(id: String) {
        var index = entities.indexOfFirst { it.id == id }
        if(index < 0 ) return
        entities.removeAt(index)
    }

    override suspend fun replace(item: TEntity) {
        delete(item.id)
        insert(item)
    }

    override suspend fun insert(entity: TEntity) {
        entities.add(entity)
    }






    // Thêm các phương thức truy vấn dữ liệu thông qua foreign key khác nếu cần
}

