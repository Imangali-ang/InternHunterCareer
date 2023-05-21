package org.example.model.Dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Intern;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class RegistrationRequestIntern {
    @NotNull
    private String userNumber;
    @NotNull
    private String role;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private int age;
    @NotNull
    private String place;
    @NotNull
    private Intern.Degree degree;
    @NotNull
    private City city;
    @NotNull
    private Speciality speciality;
    @NotNull
    private String description;
    private String skills;
    @NotNull
    private Intern.Gender gender;
    private double GPA;


    public List<String> getSkills() {
        if (!StringUtils.isEmpty(skills)) {
            return Arrays.stream(skills.split(",")).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void setSkills(List<String> skills) {
        if (skills != null) {
            this.skills = String.join("," , skills);
        }
    }

}