package com.tekup.locationvoiture.web.models.Requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    private String Name;
    private String PhoneNumber;
    private String email;
    private String msg;

 

}