package com.tekup.locationvoiture.doa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.locationvoiture.doa.Entities.Car;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    
}