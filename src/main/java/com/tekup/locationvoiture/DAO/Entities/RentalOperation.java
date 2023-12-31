package com.tekup.locationvoiture.DAO.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rent_operations")
public class RentalOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    @Enumerated(EnumType.STRING)
    private WarrantyType warrantyType;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private Double rentalFee;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public RentalOperation( String startDate, String endDate, WarrantyType warrantyType, PaymentType paymentType, Double rentalFee, Car car, Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.warrantyType = warrantyType;
        this.paymentType = paymentType;
        this.rentalFee = rentalFee;
        this.car = car;
        this.client = client;
    }

}