package org.example.service.impl;

import org.example.handlers.CompanyHandler;
import org.example.handlers.Impl.VacancyFactoryHandler;
import org.example.model.Vacancy;
import org.example.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyFactoryHandler vacancyFactoryHandler;

    @Override
    public Vacancy create(Vacancy vacancy) {
       CompanyHandler companyHandler = vacancyFactoryHandler.getInstance(vacancy);
       companyHandler.fillVacancy(vacancy);
       return vacancy;
    }
}
