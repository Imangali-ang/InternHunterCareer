package org.example.repository;

import org.example.model.Company;
import org.example.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.contacts = :userNumber")
    Optional<Company> findByCompanyNumber(String userNumber);
}
