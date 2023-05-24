package org.example.handlers.Impl;

import org.example.handlers.CompanyHandler;
import org.example.model.Vacancy;
import org.example.model.enums.Speciality;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class InternationalOnlineFactoryHandler implements CompanyHandler {
    @Value("${vacancy.offers.international.online}")
    private String offers;

    @Value("${vacancy.salary.international.online}")
    private String minSalary;

    @Override
    public void fillVacancy(Vacancy vacancy) {
        vacancy.setOffers(offers);
    }

    @Override
    public boolean checkSalary(BigDecimal salary) {
        if (salary.compareTo(new BigDecimal(minSalary)) < 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkSpeciality(Speciality speciality) {
        Set<Speciality> specialitySet = new HashSet<>(Set.of(Speciality.PROGRAMMER, Speciality.MANAGER, Speciality.TEACHER));
        if (!specialitySet.contains(speciality)) {
            return true;
        }
        return false;
    }
}
