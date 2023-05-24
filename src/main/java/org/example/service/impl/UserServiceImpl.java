package org.example.service.impl;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Dto.RegistrationRequestCompany;
import org.example.model.Dto.RegistrationRequestIntern;
import org.example.model.Intern;
import org.example.model.User;
import org.example.repository.CompanyRepository;
import org.example.repository.InternRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User registerIntern(RegistrationRequestIntern registrationRequest) {
        if(userRepository.findByUserNumber(registrationRequest.getUserNumber()).isEmpty()) {
            if(!registrationRequest.getRole().equals("INTERN")){
                throw new BasicException("ROLE SHOULD BE INTERN");
            }
            User newUser = new User(registrationRequest);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            Intern intern = new Intern(registrationRequest);
            User user = userRepository.save(newUser);
            intern.setId(user.getId());
            internRepository.save(intern);
            return user;
        }
        else {
            throw new BasicException("NUMBER ALREADY EXISTS");
        }
    }


    @Override
    @Transactional
    public User registerCompany(RegistrationRequestCompany registrationRequest) {
        if(userRepository.findByUserNumber(registrationRequest.getUserNumber()).isEmpty()) {
            if(!registrationRequest.getRole().equals("COMPANY")){
                throw new BasicException("ROLE SHOULD BE COMPANY");
            }
            User newUser = new User(registrationRequest);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            Company company = new Company(registrationRequest);
            User user = userRepository.save(newUser);
            company.setId(user.getId());
            companyRepository.save(company);
            return user;
        }
        else {
            throw new BasicException("NUMBER ALREADY EXISTS");
        }
    }
}
