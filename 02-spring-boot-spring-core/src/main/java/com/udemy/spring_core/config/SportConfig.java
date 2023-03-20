package com.udemy.spring_core.config;

import com.udemy.common.Coach;
import com.udemy.common.impl.MinecraftCoach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class SportConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public Coach minecraftCoach(){
        return new MinecraftCoach();
    }
}
