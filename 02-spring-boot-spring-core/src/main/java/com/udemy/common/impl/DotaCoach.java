package com.udemy.common.impl;

import com.udemy.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DotaCoach implements Coach {

    public DotaCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doStartupStuff(){
        System.out.println("Post-Construct : " + getClass().getSimpleName());
    }

    //not used if scope=prototype
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("Pre-Destroy : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Play 20 games in low priority";
    }
}
