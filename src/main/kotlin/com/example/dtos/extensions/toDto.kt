package com.example.dtos.extensions
import com.example.dtos.responses.OrderDto
import com.example.dtos.responses.StudentDto
import com.example.entities.Order
import com.example.entities.Student

fun Order.toDto() : OrderDto {
    return OrderDto(this.id, this.name)
}

fun Student.toDto() : StudentDto{
    return StudentDto(this.id, this.name, this.age)
}