package org.example.service;

import org.example.model.Dto.RegistrationRequest;
import org.example.model.User;

public interface UserService {


    User registerUser(RegistrationRequest registrationRequest);
}
