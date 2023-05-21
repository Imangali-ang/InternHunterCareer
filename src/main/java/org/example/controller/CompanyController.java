package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Intern;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.example.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/{companyId}")
    public Company getProfile(@PathVariable("companyId") Long id){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND COMPANY WITH THIS ID"));
        return company;
    }

    @PostMapping("/{companyId}/vacancy")
    public Vacancy create(@RequestBody Vacancy vacancy){
        return vacancyService.create(vacancy);
    }
}
