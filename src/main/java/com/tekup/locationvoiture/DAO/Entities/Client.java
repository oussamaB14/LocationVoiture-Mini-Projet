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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private Long cin;
    private Long phoneNumber;
    private String address;
    private int age;

    public Client( String name, Long cin, Long phoneNumber, String address, int age) {
        this.name = name;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

}