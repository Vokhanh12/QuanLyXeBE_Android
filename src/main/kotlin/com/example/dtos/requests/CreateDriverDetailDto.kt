package com.example.dtos.requests

import com.example.dtos.responses.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime


@Serializable
data class CreateDriverDetailDto(
    val id: Int,
    val routeId: String,
    val driverId: String,
    val vehicleId: String,

    @Serializable(with = LocalDateTimeSerializer::class)
    val startTime: LocalDateTime,

    @Serializable(with = LocalDateTimeSerializer::class)
    val endTime: LocalDateTime
)
