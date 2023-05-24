package org.example.service;

import org.example.filter.VacancyFilter;
import org.example.model.Dto.VacancyDto;
import org.example.model.Vacancy;

import java.util.List;

public interface VacancyService {

    VacancyDto create(Vacancy vacancy);

    List<VacancyDto> getVacancies(VacancyFilter vacancyFilter);

    VacancyDto getVacancy(Long vacancyId);

    VacancyDto takeVacancy(Long vacancyId , Long id);

    List<VacancyDto> getTakenVacancy(Long id);

    void getUnderTakenVacancy(Long vacancyId , Long id);
}
