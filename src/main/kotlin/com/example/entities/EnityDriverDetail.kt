package com.example.entities

import java.time.LocalDateTime


abstract class EnityDriverDetail(var id: String,var routeId: String, var driverId: String, var vehicleId: String)

class DriverDetail(id: String,routeId: String, driverId: String, vehicleId: String)
    : EnityDriverDetail(id, routeId, driverId, vehicleId){
    lateinit var startTime: LocalDateTime
    lateinit var endTime: LocalDateTime
}

