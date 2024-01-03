package com.tekup.locationvoiture.DAO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.DAO.Entities.TransmissionType;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    
    List<Car> findByName(String name);

    List<Car> findByBrand(String brand);

    List<Car> findByTransmissionType(TransmissionType transmissionType);

    List<Car> findByisAvailable(boolean status);

 
    
}