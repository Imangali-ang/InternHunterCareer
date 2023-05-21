package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.Speciality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private Speciality speciality;

    private Long companyId;

    private String internIds;

    private enum VacancyType{
        ONLINE ,
        OFFLINE;
    }



}
