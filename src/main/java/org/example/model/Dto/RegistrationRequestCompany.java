package org.example.model.Dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Intern;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;

@Getter @Setter
public class RegistrationRequestCompany {

    @NotNull
    private String userNumber;

    @NotNull
    private String role;

    @NotNull
    private String password;

    @NotNull
    private String fullName;

    @NotNull
    private String address;

    @NotNull
    private City city;

    @NotNull
    private Speciality speciality;

    @NotNull
    private String description;
}
