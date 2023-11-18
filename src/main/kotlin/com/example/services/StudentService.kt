package com.example.services

import com.example.commands.*
import com.example.entities.Student
import com.example.repositories.inMemory.StudentRepository

class StudentService(private val studentRepository: StudentRepository) : IStudentService {
    override suspend fun getAllStudents(command: GetAllOrdersCommand): List<Student> {
        return studentRepository.getAll()
    }

    override suspend fun getOrderById(command: GetOrderByIdCommand): Student? {
        TODO("Not yet implemented")
    }

    override suspend fun createOrder(command: CreateOrderCommand): Student {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrder(command: UpdateOrderCommand): Student? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOrder(command: DeleteOrderCommand) {
        TODO("Not yet implemented")
    }

}