package com.example.services

import com.example.commands.GetAccountByUsernameAndPasswordCommand
import com.example.repositories.inMemory.AccountRepository

class AccountService(private val accountRepository: AccountRepository): IAccountService {
    override suspend fun loginAccount(command: GetAccountByUsernameAndPasswordCommand): String? {
        return accountRepository.getTypeByUsernameAndPassword(command.username, command.password)
    }

}