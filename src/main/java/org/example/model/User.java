package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Dto.RegistrationRequestCompany;
import org.example.model.Dto.RegistrationRequestIntern;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userNumber;

    private String fullName;

    @Column(nullable = false)
    private String password;


    public User(RegistrationRequestIntern registrationRequest) {
        this.userNumber = registrationRequest.getUserNumber();
        this.fullName = registrationRequest.getFullName();
        this.password = registrationRequest.getPassword();
        this.userRole = UserRole.valueOf(registrationRequest.getRole().toUpperCase());
    }

    public User(RegistrationRequestCompany registrationRequest) {
        this.userNumber = registrationRequest.getUserNumber();
        this.fullName = registrationRequest.getFullName();
        this.password = registrationRequest.getPassword();
        this.userRole = UserRole.valueOf(registrationRequest.getRole().toUpperCase());
    }

    public User() {
    }

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public enum UserRole{
        INTERN,
        COMPANY;
    }
}


