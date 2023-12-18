package com.example.repositories.inMemory

import com.example.entities.Driver


object Drivers: StringIdTable(){

    val name = varchar("name",50)
    val numberPhone = varchar("number_phone",10)
    val address = varchar("address",100)

}

class DriverRepository: BaseRepository<Driver>() {

}

