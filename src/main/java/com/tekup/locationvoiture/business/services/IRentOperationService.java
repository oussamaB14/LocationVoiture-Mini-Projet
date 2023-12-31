package com.tekup.locationvoiture.business.services;

import java.util.Optional;

import com.tekup.locationvoiture.DAO.Entities.RentalOperation;

import java.util.List;

public interface IRentOperationService {
    public Optional <RentalOperation> getRentOperation(Long id);
    public RentalOperation addRentalOperation(RentalOperation r);
    public RentalOperation updateRentalOperation(RentalOperation r);
    public void deleteRentalOperation(Long id);
    public List<RentalOperation> getAllRentalOperations();
    public RentalOperation gRentalOperationByCarId(Long id);
    public double getRentedCarsCount();
    //public List<RentalOperation> getAllRentalOperationsByUser(Long id);
}