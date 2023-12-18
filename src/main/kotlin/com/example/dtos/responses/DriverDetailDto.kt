package com.example.dtos.responses

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class DriverDetailDto(
    val id: String,
    val routeId: String,
    val driverId: String,
    val vehicleId: String,

    @Serializable(with = LocalDateTimeSerializer::class)
    val startTime: LocalDateTime,

    @Serializable(with = LocalDateTimeSerializer::class)
    val endTime: LocalDateTime

)

