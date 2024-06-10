package com.pfa.PFABackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pfa.PFABackend.Model.User;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // any properties that are null will not be included in the JSON output.
@JsonIgnoreProperties(ignoreUnknown = true) // if the JSON contains properties that are not defined in the ReqRes class, those properties will be ignored and will not cause an error
public class ReqRes {

    private int statusCode;

    private String error;

    private String message;

    private String token;

    private String refreshToken;

    private String expirationTime;

    private String firstname;

    private String lastname;

    private String email;

    private String role;

    private String password;

    private User user;

    private List<User> usersList;

}
