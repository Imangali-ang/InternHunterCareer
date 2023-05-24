package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.filter.VacancyFilter;
import org.example.model.Dto.VacancyDto;
import org.example.model.Intern;
import org.example.model.User;
import org.example.model.Vacancy;
import org.example.repository.InternRepository;
import org.example.repository.UserRepository;
import org.example.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/intern")
public class InternController {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/{internId}")
    public Intern getProfile(@PathVariable("internId") Long id){
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        Intern intern = internRepository.findByInternNumber(user.getUserNumber())
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        return intern;
    }

    @GetMapping("/{internId}/vacancies")
    public List<VacancyDto> getVacancies(
            @RequestParam(value = "city" , required = false) String city ,
            @RequestParam(value = "speciality" , required = false) String speciality ,
            @RequestParam(value = "name" , required = false) String name
    ){
        VacancyFilter vacancyFilter = VacancyFilter.builder()
                .city(city)
                .speciality(speciality)
                .name(name)
                .build();
        return vacancyService.getVacancies(vacancyFilter);
    }

}
