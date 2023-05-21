package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Company;
import org.example.model.Intern;
import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/{companyId}")
    public Company getProfile(@PathVariable("companyId") Long id){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND COMPANY WITH THIS ID"));
        return company;
    }
}
