package com.netcracker.edu.botlocation.services.implementations;

import org.springframework.stereotype.Component;

import com.netcracker.edu.botlocation.services.interfaces.LocationService;

@Component
public class LocationServiceImpl implements LocationService {
    //TODO add repo layer

    @Override
    public String getLocationById(Integer id) {
        return "Test Location";
    }
}
