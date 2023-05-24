package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.City;
import org.example.model.enums.Speciality;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal salary;

    private String requirements;

    private String offers;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "intern_ids")
    private String internIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacancy_type")
    private VacancyType vacancyType;

    public enum VacancyType{
        ONLINE ,
        OFFLINE;
    }


    public List<String> getInternIds() {
        if (internIds!=null && internIds.length()!=0) {
            return Arrays.stream(internIds.split(",")).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void setInternIds(List<String> internIds) {
        if (internIds != null) {
            this.internIds = String.join("," , internIds);
        }
    }
}
