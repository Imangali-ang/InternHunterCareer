package org.example.service.impl;

import org.example.Exceptions.models.BasicException;
import org.example.adapter.VacancyToDtoAdapter;
import org.example.filter.VacancyFilter;
import org.example.handlers.CompanyHandler;
import org.example.handlers.Impl.VacancyFactoryHandler;
import org.example.mapper.VacancyMapper;
import org.example.model.Dto.VacancyDto;
import org.example.model.Vacancy;
import org.example.repository.VacancyRepository;
import org.example.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyFactoryHandler vacancyFactoryHandler;
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private VacancyToDtoAdapter vacancyToDtoAdapter;
    @Autowired
    private VacancyMapper vacancyMapper;

    @Override
    @Transactional
    public VacancyDto create(Vacancy vacancy) {
        CompanyHandler companyHandler = vacancyFactoryHandler.getInstance(vacancy);
        if (vacancy.getOffers() == null || vacancy.getOffers().length() == 0) {
            companyHandler.fillVacancy(vacancy);
        }
        if (companyHandler.checkSalary(vacancy.getSalary())) {
            throw new BasicException("SALARY CAN'T PASS VALIDATION");
        }
        if (companyHandler.checkSpeciality(vacancy.getSpeciality())) {
            throw new BasicException("SPECIALITY CAN'T PASS VALIDATION");
        }
        Vacancy vacancySaved = vacancyRepository.save(vacancy);
        VacancyDto vacancyDto = vacancyToDtoAdapter.convert(vacancySaved);
        return vacancyDto;
    }

    @Override
    public List<VacancyDto> getVacancies(VacancyFilter vacancyFilter) {
        List<Vacancy> vacancies = vacancyMapper.getList(vacancyFilter);
        List<VacancyDto> vacancyDtos = vacancies.stream().map(vacancyToDtoAdapter::convert).toList();
        return vacancyDtos;
    }

    @Override
    public VacancyDto getVacancy(Long vacancyId) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new BasicException("NOT FIND VACANCY"));
        return vacancyToDtoAdapter.convert(vacancy);
    }

    @Override
    @Transactional
    public VacancyDto takeVacancy(Long vacancyId, Long id) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new BasicException("NOT FIND VACANCY"));
        List<String> ids = vacancy.getInternIds();
        if(ids.contains(""+id)){
            throw new BasicException("ALREADY TAKEN VACANCY");
        }
        ids.add(""+id);
        vacancy.setInternIds(ids);
        vacancyRepository.save(vacancy);
        return vacancyToDtoAdapter.convert(vacancy);
    }

    @Override
    public List<VacancyDto> getTakenVacancy(Long id) {
        List<Vacancy> vacancies = vacancyRepository.findByInternId(""+id);
        return  vacancies.stream().map(vacancyToDtoAdapter::convert).toList();
    }

    @Override
    @Transactional
    public void getUnderTakenVacancy(Long vacancyId , Long id) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new BasicException("NOT FIND VACANCY"));
        if(!vacancy.getInternIds().contains(""+id)){
            throw new BasicException("INTERN DOESN'T HAVE VACANCY");
        }
        List<String> ids = vacancy.getInternIds();
        ids.remove(""+id);
        vacancy.setInternIds(ids);
        vacancyRepository.save(vacancy);
    }

}
