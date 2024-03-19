package com.example.aopbefore;

import com.example.aopbefore.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopBeforeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopBeforeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return args -> {
            demoTheBeforeAdvice(accountDAO);

            System.out.println("\n let's call it again!\n");

            demoTheBeforeAdvice(accountDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO) {
        accountDAO.addAccount();
    }
}
