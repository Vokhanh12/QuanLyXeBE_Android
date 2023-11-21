package com.example.dtos.extensions
import com.example.dtos.responses.OrderDto
import com.example.dtos.responses.StudentDto
import com.example.dtos.responses.VehicleDto
import com.example.entities.Order
import com.example.entities.Student
import com.example.entities.Vehicle

fun Order.toDto() : OrderDto {
    return OrderDto(this.id, this.name)
}

fun Student.toDto() : StudentDto{
    return StudentDto(this.id, this.name, this.age)
}

fun Vehicle.toDto() : VehicleDto{
    return VehicleDto(this.id, this.vehicle_id, this.vehicle_name, this.vehicle_type, this.start_year_of_use, this.url_image)
}