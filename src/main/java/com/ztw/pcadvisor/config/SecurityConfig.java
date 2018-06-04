package com.ztw.pcadvisor.config;

import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


/**
 * The Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Get user service.
     *
     * @return the user service
     */
    @Bean
    public UserService getUserService(){
        return new UserService();
    }

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;


    private String[] PUBLIC_MATCHERS={
            "/css/**",
            "/scripts/**",
            "/images/**",
            "/",
            "/login/**",
            "/register/**",
            "/api/currency"
    };

    /**
     * Config authentication.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .formLogin()
                .loginPage("/login").usernameParameter("username").passwordParameter("password")
                .and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and()
                .csrf()
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/search", "/api/**", "/pcconfig").fullyAuthenticated()
                .antMatchers("/admin/**").hasRole("ADMIN");
    }

    /**
     * Gets Persistent token repository.
     *
     * @return the persistent token repository
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        final JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }


}
