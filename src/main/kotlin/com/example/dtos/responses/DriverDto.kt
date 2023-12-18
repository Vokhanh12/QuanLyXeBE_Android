package com.example.dtos.responses

import kotlinx.serialization.Serializable

@Serializable
data class DriverDto (
    val id: String,
    val name: String,
    val numberPhone: String,
    val address: String
)