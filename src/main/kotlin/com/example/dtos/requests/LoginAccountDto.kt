package com.example.dtos.requests

import kotlinx.serialization.Serializable


@Serializable
class LoginAccountDto(
    val username: String,
    val password: String,
)