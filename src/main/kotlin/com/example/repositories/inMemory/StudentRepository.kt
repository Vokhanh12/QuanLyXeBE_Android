package com.example.repositories.inMemory

import com.example.entities.Order
import com.example.entities.Student
import com.example.repositories.interfaces.IOrderRepository
import com.example.repositories.interfaces.IStudentRepository
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Students : IntIdTable() {
    val name = varchar("name", 255)
    val age = integer("age")
}

class StudentRepository : BaseRepository<Student>() , IStudentRepository {
    override suspend fun getAll(): List<Student> {
        return transaction {
            Students.selectAll().map { rowToStudent(it) }
        }
    }

    private fun rowToStudent(row: ResultRow): Student {
        return Student(row[Students.id].value.toString()).apply {
            name = row[Students.name]
            age = row[Students.age]
        }
    }

}