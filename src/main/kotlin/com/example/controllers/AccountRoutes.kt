package com.example.controllers

import com.example.commands.GetAccountByUsernameAndPasswordCommand
import com.example.dtos.requests.LoginAccountDto
import com.example.repositories.inMemory.AccountRepository
import com.example.services.AccountService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

var repositoryAccount = AccountRepository()
var serviceAccount = AccountService(repositoryAccount)
fun Route.addAccountRoutes (){

    route("api/login"){

        post{

            val dto = call.receive<LoginAccountDto>()
            val command = GetAccountByUsernameAndPasswordCommand(dto.username, dto.password)

            val type = serviceAccount.loginAccount(command)

            if (type != null) {
                call.respond(HttpStatusCode.OK, mapOf("type" to type))
            } else {
                call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
            }


        }


    }

}


