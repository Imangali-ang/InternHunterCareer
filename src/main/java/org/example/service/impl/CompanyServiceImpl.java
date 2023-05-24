package org.example.service.impl;

import org.example.Exceptions.models.BasicException;
import org.example.adapter.VacancyToDtoAdapter;
import org.example.model.Company;
import org.example.model.Dto.VacancyDto;
import org.example.model.Intern;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.example.repository.InternRepository;
import org.example.repository.VacancyRepository;
import org.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jxls.util.JxlsHelper;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private VacancyToDtoAdapter vacancyToDtoAdapter;

    @Autowired
    private InternRepository internRepository;


    @Override
    public List<VacancyDto> getVacancies(Long id) {
        Company company  = companyRepository.findById(id)
                .orElseThrow(()->new BasicException("COULDN'T FIND ID"));
        List<Vacancy> vacancies = vacancyRepository.findByCompanyId(id);
        return vacancies.stream().map(vacancyToDtoAdapter::convert).toList();
    }

    @Override
    public List<Intern> getInternsByVacancy(Long vacancyId, Long id) {
        Company company  = companyRepository.findById(id)
                .orElseThrow(()->new BasicException("COULDN'T FIND COMPANY ID"));
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(()-> new BasicException("COULDN'T FIND VACANCY"));
        List<String> ids = vacancy.getInternIds();
        return internRepository.findAllById(ids.stream().map(Long::parseLong).toList());
    }
}
