package com.example.dtos.responses

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
)