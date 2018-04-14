package com.ztw.pcadvisor.config;

import com.ztw.pcadvisor.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Bean
    public AdminService getService(){
        return new AdminService();
    }

}
