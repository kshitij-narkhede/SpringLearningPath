package com.knark.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach  implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Run for 5 minutes";
    }
}
