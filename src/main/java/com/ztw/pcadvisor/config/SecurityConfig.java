package com.ztw.pcadvisor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String[] PUBLIC_MATCHERS={
            "/resources/**",
            "/static/**",
            "/css/**",
            "/scripts/**",
            "/images/**",
            "/templates/**"
    };

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/login", "/register").permitAll()
                .antMatchers("/admin").denyAll();
    }

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity
                .ignoring()
                .antMatchers(PUBLIC_MATCHERS);
    }


}
