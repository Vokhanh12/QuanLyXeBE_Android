package com.example.services

import com.example.commands.GetAccountByUsernameAndPasswordCommand

interface IAccountService {
    suspend fun loginAccount(command : GetAccountByUsernameAndPasswordCommand): Boolean

}