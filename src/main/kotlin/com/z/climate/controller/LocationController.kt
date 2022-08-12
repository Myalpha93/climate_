package com.z.climate.controller

import com.z.climate.model.Location
import com.z.climate.service.LocationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/location")
class LocationController(locationService: LocationService): BasicController<Location,String>(locationService) {

}