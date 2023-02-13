package com.example.AacademyProject.controller;

import com.example.AacademyProject.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/email")
public class EmailController {
    @Autowired
    EmailRepository emailRepository; //после да отиде в сървис

    @PostMapping(path = "/ifExists")
    public boolean getEmail(@RequestBody String email){
        return emailRepository.existsByemailAddress(email);
    }
}
