package com.tekup.locationvoiture.web.Models.Requests;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "cars")
public class CarForm {
    private String name;
    private double price;
    private String brand;
    private String model;
    private int year;
    private boolean isAvailable = true;
    private String description;
    
}