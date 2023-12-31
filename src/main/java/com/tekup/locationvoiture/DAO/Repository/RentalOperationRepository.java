package com.tekup.locationvoiture.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.locationvoiture.DAO.Entities.RentalOperation;

@Repository
public interface RentalOperationRepository extends JpaRepository<RentalOperation,Long> {

    RentalOperation findFirstByCar_Id(Long id);
     
    
}