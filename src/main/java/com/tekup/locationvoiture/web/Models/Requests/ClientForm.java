package com.tekup.locationvoiture.web.models.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientForm {
    private String name;
    private Long cin;
    private Long phoneNumber;
    private String address;
    private int age;
    
}