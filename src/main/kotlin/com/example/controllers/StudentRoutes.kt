package com.example.controllers

import com.example.commands.GetAllOrdersCommand
import com.example.dtos.extensions.toDto
import com.example.repositories.inMemory.StudentRepository
import com.example.services.StudentService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

var studentRepository = StudentRepository()
var studentService = StudentService(studentRepository)
fun Route.addStudentRoutes(){

    route("api/v1/students") {
        get {
            val command = GetAllOrdersCommand()
            val students = studentService.getAllStudents(command)
            val studentDto = students.map { it.toDto() }
            call.respond(studentDto)
        }
    }


}