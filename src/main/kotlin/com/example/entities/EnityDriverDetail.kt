package com.example.entities

import java.time.LocalDateTime

abstract class EnityDriverDetail(var routeId: String, var driverId: String, var vehicleId: String)

class DriverDetail(routeId: String, driverId: String, vehicleId: String)
    : EnityDriverDetail(routeId,driverId,vehicleId){
    lateinit var startTime: LocalDateTime
    lateinit var endTime: LocalDateTime
}

