package com.crossasyst.onetoone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientRequest {
    private String firstName;
    private String lastName;
    private AddressRequest address;

}
