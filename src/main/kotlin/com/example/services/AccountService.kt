package com.example.services

import com.example.commands.GetAccountByUsernameAndPasswordCommand
import com.example.repositories.inMemory.AccountRepository

class AccountService(private val accountRepository: AccountRepository): IAccountService {
    override suspend fun loginAccount(command: GetAccountByUsernameAndPasswordCommand): Boolean {
        return accountRepository.findByUsernameAndPassword(command.username,command.password)
    }

}