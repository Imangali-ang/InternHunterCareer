package org.example.handlers;

import org.example.model.Vacancy;
import org.example.model.enums.Speciality;

import java.math.BigDecimal;

public interface CompanyHandler {

    void fillVacancy(Vacancy vacancy);

    boolean checkSalary(BigDecimal salary);

    boolean checkSpeciality(Speciality speciality);
}
