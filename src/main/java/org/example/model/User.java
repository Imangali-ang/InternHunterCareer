package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Dto.RegistrationRequest;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userNumber;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String password;


    public User(RegistrationRequest registrationRequest) {
        this.userNumber = registrationRequest.getUserNumber();
        this.firstname = registrationRequest.getFirstName();
        this.lastname = registrationRequest.getLastName();
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


