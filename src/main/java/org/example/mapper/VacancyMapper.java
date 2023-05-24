package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.filter.VacancyFilter;
import org.example.model.Vacancy;

import java.util.List;

@Mapper
public interface VacancyMapper{
    List<Vacancy> getList(VacancyFilter vacancyFilter);

    Long countList(VacancyFilter vacancyFilter);
}
