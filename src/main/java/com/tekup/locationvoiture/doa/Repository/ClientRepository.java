package com.tekup.locationvoiture.doa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.locationvoiture.doa.Entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    
}