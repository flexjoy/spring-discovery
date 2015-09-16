package com.springapp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring security config.
 *
 * @author Sergey Cherepanov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/person/add/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/person/edit/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/person/delete/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confirmDelete/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/");
    }
}
