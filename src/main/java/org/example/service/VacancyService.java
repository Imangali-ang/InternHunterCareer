package org.example.service;

import org.example.model.Dto.VacancyDto;
import org.example.model.Vacancy;

public interface VacancyService {

    VacancyDto create(Vacancy vacancy);
}
