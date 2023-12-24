package com.tekup.locationvoiture.web.models.Requests;
import com.tekup.locationvoiture.doa.Entities.FuelType;
import com.tekup.locationvoiture.doa.Entities.TransmissionType;

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
    private String img;
    private Double millage;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private int year;
    private boolean isAvailable = true;
    private String description;
    
}