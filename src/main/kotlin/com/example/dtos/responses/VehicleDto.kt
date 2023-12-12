package com.example.dtos.responses

import kotlinx.serialization.Serializable
@Serializable
data class VehicleDto(
    val id: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val status: String,
    val urlImage: String
)