package com.org.car.app.repository;

import com.org.car.app.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarMangoRepository extends CrudRepository<Car, String> {
    public Car findByIdAndMake(String id,String make);
}
