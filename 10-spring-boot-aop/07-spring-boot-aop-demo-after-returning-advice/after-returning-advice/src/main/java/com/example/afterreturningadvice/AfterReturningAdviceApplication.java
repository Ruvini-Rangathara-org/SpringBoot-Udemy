package com.example.afterreturningadvice;

import com.example.afterreturningadvice.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AfterReturningAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfterReturningAdviceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return runner -> {
			demoTheAfterReturningAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}


}
