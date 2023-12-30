package com.tekup.locationvoiture.web.models.Requests;

import com.tekup.locationvoiture.DAO.Entities.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class RentForm {
     private String startDate;
    private String endDate;
    private String warrantyType;
    private String paymentType;
    private String rentalFee;
    private Car car;
    
}