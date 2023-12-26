package com.example.dtos.responses

import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class LocationDto(
    val id: String,
    val name: String,

    @Serializable(with = BigDecimalSerializer::class)
    val latitude: BigDecimal?,
    @Serializable(with = BigDecimalSerializer::class)
    val longitude: BigDecimal?,
)