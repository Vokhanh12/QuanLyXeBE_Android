package com.example.commands

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

fun CreateVehicleCommand.toEntity(): Vehicle{

    val uniqueID = UUID.randomUUID().toString()
    val vehicle = Vehicle(uniqueID)

    vehicle.code = this.code
    vehicle.name = this.name
    vehicle.type = this.type
    vehicle.start_year_of_use = this.startYearOfUse
    vehicle.url_image = this.urlImage

    return vehicle

}