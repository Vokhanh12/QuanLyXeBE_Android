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
    var vehicle_id: String = ""
    var vehicle_name: String = ""
    var vehicle_type: String = ""
    var start_year_of_use: String = ""
    var url_image: String = ""
}