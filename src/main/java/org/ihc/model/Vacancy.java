package org.ihc.model;

import org.ihc.model.enums.Speciality;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

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
