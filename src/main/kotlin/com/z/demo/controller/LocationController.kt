package com.z.demo.controller

import com.z.demo.model.Location
import com.z.demo.service.LocationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/location")
class LocationController(locationService: LocationService): BasicController<Location,String>(locationService) {

}