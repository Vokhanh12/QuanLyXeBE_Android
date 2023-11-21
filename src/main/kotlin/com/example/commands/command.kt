package com.example.commands

// Command Oder
data class CreateOrderCommand(val name : String)
data class DeleteOrderCommand (val orderId : String)
class GetAllOrdersCommand
data class GetOrderByIdCommand(val orderId : String)
data class UpdateOrderCommand (val orderId : String, val name : String)


// Command Student
class GetAllStudentCommand


// Command Vehicle

class GetAllVehicleCommand