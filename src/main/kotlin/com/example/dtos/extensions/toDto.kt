package com.example.dtos.extensions
import com.example.dtos.responses.*
import com.example.entities.*

fun Order.toDto() : OrderDto {
    return OrderDto(this.id, this.name)
}

fun Student.toDto() : StudentDto{
    return StudentDto(this.id, this.name, this.age)
}

fun Vehicle.toDto() : VehicleDto{
    return VehicleDto(this.id, this.name, this.type, this.start_year_of_use, this.status, this.url_image)
}

fun Account.toDto(): AccountDto{
    return AccountDto(this.id, this.username, this.password, this.type)
}

fun DriverDetail.toDto(): DriverDetailDto{
    return DriverDetailDto(this.id,this.routeId, this.driverId, this.vehicleId, this.startTime, this.endTime)
}

fun Location.toDto(): LocationDto{
    return LocationDto(this.id,this.name, this.latitude,this.longitude)
}