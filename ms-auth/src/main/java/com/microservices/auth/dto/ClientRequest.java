package com.microservices.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private Long nationalId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public ClientRequest(RegisterRequest registerRequest) {
        this.nationalId = registerRequest.getNationalId();
        this.firstName = registerRequest.getFirstName();
        this.middleName = registerRequest.getMiddleName();
        this.lastName = registerRequest.getLastName();
        this.email = registerRequest.getEmail();
        this.phoneNumber = registerRequest.getPhoneNumber();
    }
}
