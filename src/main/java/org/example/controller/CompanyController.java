package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Dto.VacancyDto;
import org.example.model.Intern;
import org.example.model.User;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.example.repository.UserRepository;
import org.example.service.CompanyService;
import org.example.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{companyId}")
    public Company getProfile(@PathVariable("companyId") Long id){
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        Company company = companyRepository.findByCompanyNumber(user.getUserNumber())
                .orElseThrow(() -> new BasicException("CAN'T FIND COMPANY WITH THIS ID"));
        return company;
    }

    @PostMapping("/{companyId}/vacancy")
    public VacancyDto create(@RequestBody Vacancy vacancy){
        return vacancyService.create(vacancy);
    }

    @GetMapping("/{companyId}/vacancy")
    public List<VacancyDto> getVacancies(@PathVariable("companyId") Long id){
        return companyService.getVacancies(id);
    }

    @GetMapping("/{companyId}/vacancy/{vacancyId}/inters")
    public List<Intern> getInternsByVacancy(
            @PathVariable("companyId") Long id,
            @PathVariable("vacancyId") Long vacancyId
    ){
        return companyService.getInternsByVacancy(vacancyId , id);
    }
}
