package com.udemy.common.impl;

import com.udemy.common.Coach;

public class MinecraftCoach implements Coach {

    public MinecraftCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Mine a stack of diamonds";
    }
}
