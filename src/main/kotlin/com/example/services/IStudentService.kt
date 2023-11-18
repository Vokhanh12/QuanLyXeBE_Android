package com.example.services

import com.example.commands.*
import com.example.entities.Student

interface IStudentService {
    suspend fun getAllStudents(command : GetAllOrdersCommand) : List<Student>
    suspend fun getOrderById(command : GetOrderByIdCommand) : Student?
    suspend fun createOrder(command : CreateOrderCommand) : Student
    suspend fun updateOrder(command : UpdateOrderCommand) : Student?
    suspend fun deleteOrder(command : DeleteOrderCommand)
}