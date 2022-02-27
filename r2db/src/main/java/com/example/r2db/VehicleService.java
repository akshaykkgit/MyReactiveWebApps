package com.example.r2db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;


    public Flux<Vehicle> getVehicleByMake(String make) {
        return vehicleRepository.findByMake(make);
    }
    public Mono<Vehicle> getById(int id) {
        return vehicleRepository.findById(id);
    }

}
