package com.example.dtos.requests

import kotlinx.serialization.Serializable


@Serializable
data class CreateVehicleDto (
    val code: String,
    val name: String,
    val type: String,
    val start_year_of_use: String,
    val url_image: String
)