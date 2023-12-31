package com.tekup.locationvoiture.DAO.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long Id;
    private String Name;
    private String PhoneNumber;
    private String email;
    private String msg;

    public Contact(String Name, String PhoneNumber, String email, String msg) {
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.email = email;
        this.msg = msg;
    }

}