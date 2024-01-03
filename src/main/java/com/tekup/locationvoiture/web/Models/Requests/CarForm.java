package com.tekup.locationvoiture.web.models.Requests;
import com.tekup.locationvoiture.DAO.Entities.FuelType;
import com.tekup.locationvoiture.DAO.Entities.TransmissionType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarForm {
    private String name;
    private double price;
    private String brand;
    private String img;
    private Double millage;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TransmissionType transmissionType;
    private int year;
    private boolean isAvailable = true;
    private String description;

 
    
}