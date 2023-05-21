package org.example.model;

import com.sun.istack.NotNull;
import org.example.model.Dto.RegistrationRequestCompany;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @NotNull
    private String address;
    private String contacts;
    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;
    private String description;

    public Company(RegistrationRequestCompany registrationRequest) {
        this.name = registrationRequest.getFullName();
        this.address = registrationRequest.getAddress();
        this.contacts = registrationRequest.getUserNumber();
        this.city = registrationRequest.getCity();
        this.speciality = registrationRequest.getSpeciality();
        this.description = registrationRequest.getDescription();
    }

    public Company() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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
}

