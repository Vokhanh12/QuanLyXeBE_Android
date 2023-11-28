package com.example.dtos.responses

import kotlinx.serialization.Serializable

@Serializable
class AccountDto(
    val id: String,
    val username: String,
    val password: String,
    val typeAccount: String
)