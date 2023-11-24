package com.tekup.locationvoiture.business.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.doa.Entities.Car;
import com.tekup.locationvoiture.doa.Repository.CarRepository;
@Service
public class CarServiceImp implements ICarService{
    @Autowired
    CarRepository carRepository;
    @Override
    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id); 
        // throw new UnsupportedOperationException("Unimplemented method 'getCar'");
    }

    @Override
    public Car addCar(Car c) {
        return carRepository.save(c);
        // throw new UnsupportedOperationException("Unimplemented method 'addCar'");
    }

    @Override
    public Car updateCar(Car c) {
        return carRepository.save(c);
        
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getAllCars'");
    }
    
}