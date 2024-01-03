package com.tekup.locationvoiture.business.services;

import java.util.List;
import java.util.Optional;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.DAO.Entities.TransmissionType;

public interface ICarService {
    public Optional <Car> getCar(Long id);
    public Car addCar(Car c);
    public Car updateCar(Car c);
    public void deleteCar(Long id);
    public List<Car> getAllCars();
    public double getNumberOfCars();
      public List<Car> getCarsByName(String name);
    public List<Car> getCarsByBrandName(String brand);
    public List<Car> getCarsByTranmissionType( TransmissionType transmissionType);
    public List<Car> getCarsByAvailability(boolean status);

    
}