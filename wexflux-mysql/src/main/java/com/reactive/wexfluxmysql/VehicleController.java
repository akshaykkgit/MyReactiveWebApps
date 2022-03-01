package com.reactive.wexfluxmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
    @GetMapping("/get")
    public Flux<Vehicle> getVehicleByMake(){
        return vehicleService.getVehicleByMake("Ford");
    }
    @GetMapping("/get/{id}")
    public Mono<Vehicle> getByID(@PathVariable int id){
        return vehicleService.getById(id);
    }
    @GetMapping("/test")
    public String getVal(){
        return "done";
    }

}
