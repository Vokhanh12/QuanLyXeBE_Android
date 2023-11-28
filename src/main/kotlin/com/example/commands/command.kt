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
data class CreateVehicleCommand(
    val code: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val urlImage: String
)
data class GetVehicleByIdCommand(val vehicleId: String)
data class DeleteVehicleCommand(val vehicleId: String)

// command Account

data class GetAccountByUsernameAndPasswordCommand(val username: String, val password: String)
