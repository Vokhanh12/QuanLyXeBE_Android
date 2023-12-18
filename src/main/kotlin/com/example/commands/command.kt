package com.example.commands

import java.math.BigDecimal
import java.time.LocalDateTime


//region Order Commands
data class CreateOrderCommand(val name : String)
data class DeleteOrderCommand (val orderId : String)
class GetAllOrdersCommand
data class GetOrderByIdCommand(val orderId : String)
data class UpdateOrderCommand (val orderId : String, val name : String)
//endregion

//region Student Commands
// Command Student
class GetAllStudentCommand
//endregion

//region Vehicle Commands
class GetAllVehicleCommand
data class GetAllVehicleByTypeCommand(val vehicleType: String)
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
//endregions

//region Account Commands
data class GetAccountByUsernameAndPasswordCommand(val username: String, val password: String)
//endregion

//region Route Commands
class getAllNameRouteCommand
class getIdRouteByNameCommandt

//endregion

//region Driver Commands
class GetAllDriverDetailsCommand
data class CreateDriverDetailCommand(
    val routeId: String,
    val driverId: String,
    val vehicleId: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)

// command Driver
data class CreateDriverCommand(
    val name : String,
    val numberPhone: String,
    val address: String,
)
data class DeleteDriverCommand (val orderId : String)
class GetAllDriversCommand
data class GetDriverByIdCommand(val orderId : String)
data class UpdateDriverCommand (
    val name : String,
    val numberPhone: String,
    val address: String,
)
//endregion

//region Location Commands
data class CreateLocationCommand(
    val name : String,
    val latitde: BigDecimal,
    val longitude: BigDecimal
)
data class DeleteLocationCommand (val locationId : String)
class GetAllLocationsCommand
data class GetLocationByIdCommand(val locationId : String)
data class UpdateLocationCommand (
    val name : String,
    val latitde: BigDecimal,
    val longitude: BigDecimal
)
//endregion