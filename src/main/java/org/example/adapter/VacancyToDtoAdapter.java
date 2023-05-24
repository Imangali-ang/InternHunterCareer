package org.example.adapter;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Dto.VacancyDto;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VacancyToDtoAdapter {

    @Autowired
    private CompanyRepository companyRepository;

    public VacancyDto convert(Vacancy vacancy){
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setNumberOfResponse(Optional.ofNullable(vacancy.getInternIds()).orElse("").length());
        vacancyDto.setName(vacancy.getName());
        vacancyDto.setSalary(vacancy.getSalary());
        Company company = companyRepository.findById(vacancy.getCompanyId())
                .orElseThrow(() -> new BasicException("COMPANY NOT FOUND"));
        vacancyDto.setNameOfCompany(company.getName());
        vacancyDto.setCompanyId(company.getId());
        vacancyDto.setCity(vacancy.getCity());
        vacancyDto.setVacancyType(vacancy.getVacancyType());
        vacancyDto.setDescriptionOfCompany(company.getDescription());
        vacancyDto.setRequirements(vacancy.getRequirements());
        vacancyDto.setOffers(vacancy.getOffers());
        vacancyDto.setContacts(company.getContacts());
        return vacancyDto;
    }
}
