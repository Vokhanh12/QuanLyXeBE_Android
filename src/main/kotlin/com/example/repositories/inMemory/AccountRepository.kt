package com.example.repositories.inMemory

import com.example.entities.Account
import com.example.repositories.interfaces.IAccountRepository
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object Accounts: IntIdTable(){

    val username = varchar("username",20)
    val password = varchar("password", 20)
    val type = varchar("type", 10)

}

class AccountRepository: BaseRepository<Account>(), IAccountRepository{
    override suspend fun findByUsernameAndPassword(username: String, password: String): Boolean {

       return transaction {
            Accounts.select{
                Accounts.username eq username and (Accounts.password eq password)
            }.count() > 0
        }

    }



}