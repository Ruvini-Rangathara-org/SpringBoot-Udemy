package com.example.mvcsecdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}1234")
                .roles("MANAGER","EMPLOYEE")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}1234")
                .roles("ADMIN","EMPLOYEE","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }


}
