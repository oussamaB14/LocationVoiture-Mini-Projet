package com.tekup.locationvoiture.business.services;

import java.util.Optional;
import java.util.List;



import com.tekup.locationvoiture.doa.Entities.RentalOperation;

public interface IRentOperationService {
    public Optional <RentalOperation> getRentOperation(Long id);
    public RentalOperation addRentalOperation(RentalOperation r);
    public RentalOperation updateRentalOperation(RentalOperation r);
    public void deleteRentalOperation(Long id);
    public List<RentalOperation> getAllRentalOperations();
    //public List<RentalOperation> getAllRentalOperationsByUser(Long id);
}