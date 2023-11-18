package com.example.dtos.responses

import kotlinx.serialization.Serializable
@Serializable
data class StudentDto(
    val id : String,
    val name : String,
    val age : Int?
)
