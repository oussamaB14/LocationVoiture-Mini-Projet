package com.tekup.locationvoiture.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.locationvoiture.DAO.Entities.Car;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    
}