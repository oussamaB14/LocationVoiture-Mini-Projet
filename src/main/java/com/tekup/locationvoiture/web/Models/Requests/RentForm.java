package com.tekup.locationvoiture.web.models.Requests;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.DAO.Entities.Client;
import com.tekup.locationvoiture.DAO.Entities.PaymentType;
import com.tekup.locationvoiture.DAO.Entities.WarrantyType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentForm {
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
    
}