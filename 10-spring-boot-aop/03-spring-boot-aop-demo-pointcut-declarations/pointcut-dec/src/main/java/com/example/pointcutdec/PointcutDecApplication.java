package com.example.pointcutdec;

import com.example.pointcutdec.dao.AccountDAO;
import com.example.pointcutdec.dto.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointcutDecApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointcutDecApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return args -> {
			demoTheBeforeAdvice(accountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();
		System.out.println("\n\n");

		accountDAO.deleteAccount(new Account(), true);
	}
}
