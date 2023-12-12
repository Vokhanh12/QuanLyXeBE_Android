package com.example.commands

import java.sql.Date

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
    val id: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val status: String,
    val urlImage: String
)
data class GetVehicleByIdCommand(val vehicleId: String)
data class DeleteVehicleCommand(val vehicleId: String)

// command Account
data class GetAccountByUsernameAndPasswordCommand(val username: String, val password: String)

// command Route
class getAllNameRouteCommand
class getIdRouteByNameCommand

// command RouteDetails



// command DriverDetails
class GetAllDriverDetailsCommand
data class CreateDriverDetailsCommand(
    val routeId: String,
    val driverId: String,
    val vehicleId: String,
    val startTime: Date,
    val endTime: Date
)

class GetVehicleNameByDriverDetailsIdCommand