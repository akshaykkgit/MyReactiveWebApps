package com.reactive.wexfluxmysql;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VehicleRepository extends ReactiveCrudRepository<Vehicle, Integer> {


   // @Query("SELECT * FROM vehicle WHERE make = :make")
    Flux<Vehicle> findByMake(String make);

    @Query("SELECT * FROM vehicle WHERE model = :model")
    Flux<Vehicle> findByModel(String model);

    Mono<Vehicle> findById(int id);
}
