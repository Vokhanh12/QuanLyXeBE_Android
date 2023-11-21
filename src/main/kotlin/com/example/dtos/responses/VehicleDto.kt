package com.example.dtos.responses

import kotlinx.serialization.Serializable


@Serializable
data class VehicleDto(
    val id: String,
    val vehicleId: String,
    val vehicleName: String,
    val vehicleType: String,
    val startYearOfUse: String,
    val urlImage: String
)