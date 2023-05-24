package org.example.model;

import org.example.model.Dto.RegistrationRequestIntern;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "intern")
public class Intern {
    @Id
    private Long id;
    private String fullName;
    private int age;
    private String place;
    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private Degree degree;
    private String contacts;
    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;
    private String description;
    private String skills;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    private double GPA;

    public Intern(RegistrationRequestIntern registrationRequest) {
        this.fullName = registrationRequest.getFullName();
        this.age = registrationRequest.getAge();
        this.place = registrationRequest.getPlace();
        this.degree = registrationRequest.getDegree();
        this.contacts = registrationRequest.getUserNumber();
        this.city = registrationRequest.getCity();
        this.speciality = registrationRequest.getSpeciality();
        this.description = registrationRequest.getDescription();
        this.setSkills(registrationRequest.getSkills());
        this.gender = registrationRequest.getGender();
        this.GPA = registrationRequest.getGPA();
    }

    public Intern() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public enum Degree{
        BACHELOR ,
        MASTER
    }

    public enum Gender {
        MAN ,
        WOMAN
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gender getSex() {
        return gender;
    }

    public void setSex(Gender gender) {
        this.gender = gender;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}

