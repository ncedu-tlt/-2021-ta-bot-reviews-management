package com.netcracker.edu.botlocation.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netcracker.edu.botlocation.services.interfaces.LocationService;

@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/getLocationById/{id}")
    public String getLocation(@PathVariable("id") Integer id) {
        return locationService.getLocationById(id);
    }
}
