package com.udemy.spring_core.rest;

import com.udemy.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
public class CoachController {

    private final Coach firstCoach;
    private final Coach secondCoach;
    private Coach thirdCoach;
    private Coach forthCoach;

    /*//using parameter name to autowire specifically (has lower priority than @Primary)
    public CoachController(Coach wowCoach) {
        this.coach1 = wowCoach;
    }*/

    public CoachController(Coach firstCoach, Coach secondCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.firstCoach = firstCoach;
        this.secondCoach = secondCoach;
    }

    @Autowired
    public void setFourthCoach(@Qualifier("minecraftCoach") Coach coach){
        this.forthCoach = coach;
    }

    //@Qualifier has the highest priority
    @Autowired
    public void setThirdCoach(@Qualifier("dotaCoach") Coach thirdCoach) {
        this.thirdCoach = thirdCoach;
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return forthCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkEquals() {
        return "Comparing beans: fistCoach == secondCoach -> " + (firstCoach == secondCoach);
    }
}
