package com.tekup.locationvoiture.web.models.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {
    private String name;
    private Long cin;
    private Long phoneNumber;
    private String address;
    private int age;
    
}