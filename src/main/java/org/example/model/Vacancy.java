package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter @Setter
@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal salary;

    private String requirements;

    private String offers;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "intern_ids")
    private String internIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacancy_type")
    private VacancyType vacancyType;

    public enum VacancyType{
        ONLINE ,
        OFFLINE;
    }



}
