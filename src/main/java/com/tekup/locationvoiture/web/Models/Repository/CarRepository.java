package com.tekup.locationvoiture.web.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.locationvoiture.web.Models.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
    
}