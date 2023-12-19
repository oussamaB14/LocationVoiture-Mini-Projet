package com.tekup.locationvoiture.doa.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.locationvoiture.doa.Entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    
}