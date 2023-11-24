package com.tekup.locationvoiture.web.models.Requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarForm {
    private String name;
    private double price;
    private String brand;
    private String model;
    private int year;
    private boolean isAvailable = true;
    private String description;
    
}