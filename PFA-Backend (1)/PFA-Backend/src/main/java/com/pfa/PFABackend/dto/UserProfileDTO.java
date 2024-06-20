package com.pfa.PFABackend.dto;

import lombok.Data;

@Data
public class UserProfileDTO {
    private String firstname;
    private String lastname;
    private String email;

    private String birthDate;
    private String grade;

}
