package com.example.secuiritybasicdemo.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        PasswordEncoder passwordEncoder = passwordEncoder();

        UserDetails john = User.builder()
                .username("john")
                .password(passwordEncoder.encode("test123"))
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password(passwordEncoder.encode("test123"))
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password(passwordEncoder.encode("test123"))
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails alice = User.builder()
                .username("alice")
                .password(passwordEncoder.encode("password123"))
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan, alice);
    }
}
