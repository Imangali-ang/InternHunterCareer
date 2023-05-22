package org.example.controller;

import org.example.Exceptions.models.BasicException;
import org.example.model.Intern;
import org.example.model.User;
import org.example.repository.InternRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/intern")
public class InternController {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{internId}")
    public Intern getProfile(@PathVariable("internId") Long id){
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        Intern intern = internRepository.findByInternNumber(user.getUserNumber())
                .orElseThrow(() -> new BasicException("CAN'T FIND INTERN WITH THIS ID"));
        return intern;
    }

}
