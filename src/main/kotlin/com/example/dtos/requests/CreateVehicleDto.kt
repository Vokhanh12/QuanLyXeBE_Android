package com.example.dtos.requests

import kotlinx.serialization.Serializable


@Serializable
data class CreateVehicleDto (
    val id: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val status: String,
    val urlImage: String
)