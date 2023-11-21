package com.example.services

import com.example.commands.*
import com.example.entities.Student

interface IStudentService {
    suspend fun getAllStudents(command : GetAllOrdersCommand) : List<Student>
    suspend fun getStudentById(command : GetOrderByIdCommand) : Student?
    suspend fun createStudent(command : CreateOrderCommand) : Student
    suspend fun updateStudent(command : UpdateOrderCommand) : Student?
    suspend fun deleteStudent(command : DeleteOrderCommand)
}