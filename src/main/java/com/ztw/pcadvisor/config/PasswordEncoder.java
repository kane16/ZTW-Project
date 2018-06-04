package com.ztw.pcadvisor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The type PasswordEncoder.
 */
@Configuration
public class PasswordEncoder {

    /**
     * Get BCryptPasswordEncoder.
     *
     * @return the BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

}
