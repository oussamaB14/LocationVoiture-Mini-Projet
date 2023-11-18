package com.tekup.locationvoiture.web.Models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "clients")
public class Client {
    private Long id;
    private String name;
    private Long cin;
    private Long phoneNumber;
    private String address;
    private int age;
    public Client(){}
    
}