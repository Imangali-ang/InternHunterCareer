package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;

import javax.persistence.*;
import java.math.BigInteger;

@Getter @Setter
@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigInteger salary;

    private String requirements;

    private String offers;

    private City city;

    private Speciality speciality;

    private Long companyId;

    private String internIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacancy_type")
    private VacancyType vacancyType;

    public enum VacancyType{
        ONLINE ,
        OFFLINE;
    }



}
