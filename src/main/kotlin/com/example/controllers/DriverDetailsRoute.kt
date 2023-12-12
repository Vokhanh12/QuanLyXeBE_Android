package com.example.controllers

import com.example.commands.GetVehicleNameByDriverDetailsIdCommand
import io.ktor.server.routing.*

fun Route.DriverDetailsRoute() {

    route("api/v1/DriverDetails"){

        get{

            val command = GetVehicleNameByDriverDetailsIdCommand()



        }



    }
}