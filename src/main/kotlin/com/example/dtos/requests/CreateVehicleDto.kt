package com.example.dtos.requests

import kotlinx.serialization.Serializable


@Serializable
data class CreateVehicleDto (
    val code: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val urlImage: String
)