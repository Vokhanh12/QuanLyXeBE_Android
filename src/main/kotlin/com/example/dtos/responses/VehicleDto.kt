package com.example.dtos.responses

import kotlinx.serialization.Serializable


@Serializable
data class VehicleDto(
    val id: String,
    val code: String,
    val name: String,
    val type: String,
    val startYearOfUse: String,
    val urlImage: String
)