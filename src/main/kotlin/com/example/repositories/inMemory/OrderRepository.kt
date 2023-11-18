package com.example.repositories.inMemory

import com.example.entities.Order
import com.example.repositories.interfaces.IOrderRepository
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Orders : IntIdTable() {
    val name = varchar("name", 255)
}

class OrderRepository : BaseRepository<Order>() , IOrderRepository {

    override suspend fun getAll(): List<Order> {
        return transaction {
            Orders.selectAll().map { rowToOrder(it) }
        }
    }


    override suspend fun findById(id: String): Order? {
        return transaction {
            Orders.select { Orders.id eq id.toInt() }.singleOrNull()?.let { rowToOrder(it) }
        }
    }

    override suspend fun insert(entity: Order) {
        transaction {
            val id = Orders
                .insertAndGetId {
                    it[name] = entity.name
                }
            entity.id = id.value.toString()
        }
    }

    private fun rowToOrder(row: ResultRow): Order {
        return Order(row[Orders.id].value.toString()).apply {
            name = row[Orders.name]
        }
    }
}