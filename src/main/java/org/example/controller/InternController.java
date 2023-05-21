package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Intern;
import org.example.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/intern")
public class InternController {

    @Autowired
    private InternRepository internRepository;

    @GetMapping("/{internId}")
    public Intern getProfile(@PathVariable("internId") Long id){
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        return intern;
    }

}
