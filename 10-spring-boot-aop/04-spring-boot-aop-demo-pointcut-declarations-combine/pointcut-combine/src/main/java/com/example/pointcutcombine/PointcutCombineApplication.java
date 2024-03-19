package com.example.pointcutcombine;

import com.example.pointcutcombine.dao.AccountDAO;
import com.example.pointcutcombine.dto.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointcutCombineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointcutCombineApplication.class, args);
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

		accountDAO.setServiceCode("silver");
		accountDAO.setName("foo");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

	}
}
