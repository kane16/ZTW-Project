package com.ztw.pcadvisor.config;

import com.ztw.pcadvisor.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Admin config.
 */
@Configuration
public class AdminConfig {


    /**
     * Get admin service.
     *
     * @return the admin service
     */
    @Bean
    public AdminService getService(){
        return new AdminService();
    }

}
