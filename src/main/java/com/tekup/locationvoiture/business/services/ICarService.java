package com.tekup.locationvoiture.business.services;

import java.util.List;
import java.util.Optional;

import com.tekup.locationvoiture.DAO.Entities.Car;

public interface ICarService {
    public Optional <Car> getCar(Long id);
    public Car addCar(Car c);
    public Car updateCar(Car c);
    public void deleteCar(Long id);
    public List<Car> getAllCars();
    public double getNumberOfCars();
    
}