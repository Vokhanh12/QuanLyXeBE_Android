package com.example.dtos.responses

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.sql.Date

@Serializable
data class DriverDetailsDto(
    val routeId: String,
    val driverId: String,
    val vehicleId: String,

    @Contextual
    val startTime: Date,
    @Contextual
    val endTime: Date

)