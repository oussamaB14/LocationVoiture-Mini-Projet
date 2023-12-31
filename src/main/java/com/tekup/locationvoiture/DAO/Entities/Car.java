package com.tekup.locationvoiture.DAO.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Car( String name, double price, String brand, String img, Double millage, FuelType fuelType, TransmissionType transmissionType, int year, boolean isAvailable, String description) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.img = img;
        this.millage = millage;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.year = year;
        this.isAvailable = isAvailable;
        this.description = description;
    }

}