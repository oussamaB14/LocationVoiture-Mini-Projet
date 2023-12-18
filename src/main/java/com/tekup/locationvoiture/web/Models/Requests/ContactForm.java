package com.tekup.locationvoiture.web.models.Requests;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactForm {
    private String Name;
    private String PhoneNumber;
    private String email;
    private String msg;
}