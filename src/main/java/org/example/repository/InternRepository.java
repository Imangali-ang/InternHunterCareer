package org.example.repository;


import org.example.model.Intern;
import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {

    @Query("SELECT i FROM Intern i WHERE i.id=:id")
    Optional<Intern> findById(Long id);

    @Query("SELECT i FROM Intern i WHERE i.contacts = :userNumber")
    Optional<Intern>  findByInternNumber(String userNumber);
}
