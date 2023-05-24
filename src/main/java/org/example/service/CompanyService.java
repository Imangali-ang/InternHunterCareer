package org.example.service;

import org.example.model.Dto.VacancyDto;
import org.example.model.Intern;

import java.util.List;

public interface CompanyService {
    List<VacancyDto> getVacancies(Long id);

    List<Intern> getInternsByVacancy(Long vacancyId, Long id);
}
