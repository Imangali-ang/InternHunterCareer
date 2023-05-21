package org.example.service;

import org.example.model.Dto.RegistrationRequestCompany;
import org.example.model.Dto.RegistrationRequestIntern;
import org.example.model.User;

public interface UserService {

    User registerIntern(RegistrationRequestIntern registrationRequest);
    User registerCompany(RegistrationRequestCompany registrationRequest);
}
