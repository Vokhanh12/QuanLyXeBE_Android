package com.example.commands

import com.example.entities.DriverDetail
import com.example.entities.Order
import com.example.entities.Vehicle
import java.util.*

// Order
fun CreateOrderCommand.toEntity() : Order {

    val uniqueID = UUID.randomUUID().toString()
    val order = Order(uniqueID)

    order.name = this.name

    return order
}

fun UpdateOrderCommand.updateEntity(order: Order) : Order {

    order.name = this.name

    return order
}

// Vehicle

fun CreateVehicleCommand.toEntity(): Vehicle {
    val vehicle = Vehicle(this.id) // Sử dụng id đã có thay vì tạo mới UUID

    vehicle.name = this.name
    vehicle.type = this.type
    vehicle.start_year_of_use = this.startYearOfUse
    vehicle.url_image = this.urlImage

    return vehicle
}

// DriverDetail
fun CreateDriverDetailCommand.toEnity(): DriverDetail{
    val uniqueID = UUID.randomUUID().toString()
    val driverDetail = DriverDetail(uniqueID, this.routeId, this.driverId, this.vehicleId)

    driverDetail.startTime = this.startTime
    driverDetail.endTime = this.endTime

    return  driverDetail
}
