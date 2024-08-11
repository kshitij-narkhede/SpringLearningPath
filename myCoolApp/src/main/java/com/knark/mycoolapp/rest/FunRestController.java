package com.knark.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    @GetMapping(value = "/")
    @Value("${coach.name}")
    public String coachName;
    @Value("${team.name}")
    public String teamName;

    @GetMapping("/heal")
    public String getCoachName() {
        return coachName+ "is Coach of " + teamName;
    }
}
