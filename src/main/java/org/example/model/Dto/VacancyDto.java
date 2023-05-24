package org.example.model.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Vacancy;
import org.example.model.enums.City;

import java.math.BigDecimal;

@Setter
@Getter
public class VacancyDto {

    private int numberOfResponse;

    private String name;

    private BigDecimal salary;

    private String nameOfCompany;

    private Long companyId;

    private City city;

    private Vacancy.VacancyType vacancyType;

    private String descriptionOfCompany;

    private String requirements;

    private String offers;

    private String contacts;

    private Long vacancyId;

}
