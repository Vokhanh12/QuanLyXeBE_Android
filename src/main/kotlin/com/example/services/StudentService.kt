package com.example.services

import com.example.commands.*
import com.example.entities.Student
import com.example.repositories.inMemory.StudentRepository

class StudentService(private val studentRepository: StudentRepository) : IStudentService {
    override suspend fun getAllStudents(command: GetAllOrdersCommand): List<Student> {
        return studentRepository.getAll()
    }

    override suspend fun getStudentById(command: GetOrderByIdCommand): Student? {
        TODO("Not yet implemented")
    }

    override suspend fun createStudent(command: CreateOrderCommand): Student {
        TODO("Not yet implemented")
    }

    override suspend fun updateStudent(command: UpdateOrderCommand): Student? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStudent(command: DeleteOrderCommand) {
        TODO("Not yet implemented")
    }


}