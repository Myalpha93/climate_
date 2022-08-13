package com.z.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Location")
data class Location (
    @Id var locationID: String,
    var name: String,
    var temp: Int,
    var wind_speed: Int,
    var wind_direction: String,
    var longitud: Double,
    var latitud: Double
)


@RedisHash("Logs")
data class Logs (
    @Id var logID: String,
    var error: String,
    var timestamp: java.sql.Timestamp
)
