package org.spring.configurations;

import org.spring.controllers.ControllerUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUser {

    @Bean
    public ControllerUser getController() {
        return new ControllerUser();
    }
}
