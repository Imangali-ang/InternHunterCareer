package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Intern;
import org.example.model.User;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.example.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{companyId}")
    public Company getProfile(@PathVariable("companyId") Long id){
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        Company company = companyRepository.findByCompanyNumber(user.getUserNumber())
                .orElseThrow(() -> new BasicException("CAN'T FIND COMPANY WITH THIS ID"));
        return company;
    }

    @PostMapping("/{companyId}/vacancy")
    public Vacancy create(@RequestBody Vacancy vacancy){
        return vacancyService.create(vacancy);
    }
}
