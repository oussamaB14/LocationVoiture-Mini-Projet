package com.tekup.locationvoiture.business.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tekup.locationvoiture.business.services.IRentOperationService;
import com.tekup.locationvoiture.doa.Entities.RentalOperation;
import com.tekup.locationvoiture.doa.Repository.RentalOperationRepository;

public class RentOperationServiceImp implements IRentOperationService {
    @Autowired
    RentalOperationRepository rentRepository;

    @Override
    public Optional<RentalOperation> getRentOperation(Long id) {
        return rentRepository.findById(id);
        //throw new UnsupportedOperationException("Unimplemented method 'getRentOperation'");
    }

    @Override
    public RentalOperation addRentalOperation(RentalOperation r) {
        return rentRepository.save(r);
      
        //throw new UnsupportedOperationException("Unimplemented method 'addRentalOperation'");
    }

    @Override
    public RentalOperation updateRentalOperation(RentalOperation r) {
        return rentRepository.save(r);
        //throw new UnsupportedOperationException("Unimplemented method 'updateRentalOperation'");
    }

    @Override
    public void deleteRentalOperation(Long id) {
             rentRepository.deleteById(id);
        //throw new UnsupportedOperationException("Unimplemented method 'deleteRentalOperation'");
    }

    @Override
    public List<RentalOperation> getAllRentalOperations() {
        return rentRepository.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getAllRentalOperations'");
    }
    
}