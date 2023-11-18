package com.tekup.locationvoiture.web.Models.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.locationvoiture.web.Models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}