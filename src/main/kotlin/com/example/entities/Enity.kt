package com.example.entities

import java.math.BigDecimal

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

class Driver(id: String): Entity(id){
    var name: String = ""
    var numberPhone = ""
    var address = ""
}

class Location(id: String): Entity(id){
    var name: String = ""
    var latitude: BigDecimal? = null
    var longitude: BigDecimal? = null
}

class RouteVehicle(id: String): Entity(id){
    var name: String = ""
    var length: BigDecimal? = null
    var note: String = ""
}


