package com.example.entities

abstract class Entity(var id: String)

class Order(id: String) : Entity(id) {
    var name: String = ""
}

class Student(id : String) : Entity(id)
{
    var name : String = ""
    var age : Int? = null
}

class Vehicle(id: String) : Entity(id){
    var name: String = ""
    var type: String = ""
    var start_year_of_use: String = ""
    var status: String = ""
    var url_image: String = ""
}

class Account(id: String): Entity(id){
    var username: String = ""
    var password: String = ""
    var type: String = ""
}


