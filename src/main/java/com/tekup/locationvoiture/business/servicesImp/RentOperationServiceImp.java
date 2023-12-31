package com.tekup.locationvoiture.business.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.locationvoiture.DAO.Entities.RentalOperation;
import com.tekup.locationvoiture.DAO.Repository.RentalOperationRepository;
import com.tekup.locationvoiture.business.services.IRentOperationService;
@Service
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

    @Override
    public RentalOperation gRentalOperationByCarId(Long id) {
        return  rentRepository.findFirstByCar_Id(id);
    }

    @Override
    public double getRentedCarsCount() {
       return rentRepository.count();
    }
    
}