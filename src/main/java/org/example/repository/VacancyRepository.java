package org.example.repository;

import org.example.model.User;
import org.example.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query("SELECT v FROM Vacancy v WHERE v.internIds LIKE CONCAT('%', TRIM(:id), '%')")
    List<Vacancy> findByInternId(@Param("id") String id);

    @Query("SELECT v FROM Vacancy v WHERE v.companyId = :id")
    List<Vacancy> findByCompanyId(@Param("id") Long id);
}
