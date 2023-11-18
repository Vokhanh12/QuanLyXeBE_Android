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