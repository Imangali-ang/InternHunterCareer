package org.example.model.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    private String userNumber;
    private String password;
}
