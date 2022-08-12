package com.z.climate.config

import com.z.climate.controller.Requests
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class Config {
    @Scheduled(fixedRate = 300000)
    fun fixedRateScheduledTask() {
        Requests.llamarApi()
    }
}