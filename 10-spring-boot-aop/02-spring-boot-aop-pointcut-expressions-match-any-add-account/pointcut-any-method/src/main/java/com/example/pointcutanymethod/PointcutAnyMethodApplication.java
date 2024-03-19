package com.example.pointcutanymethod;

import com.example.pointcutanymethod.dao.AccountDAO;
import com.example.pointcutanymethod.dao.MemberDAO;
import com.example.pointcutanymethod.dto.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointcutAnyMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointcutAnyMethodApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberDAO memberDAO) {
		return args -> {
			demoTheBeforeAdvice(accountDAO, memberDAO);


		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberDAO memberDAO) {
		accountDAO.addAccount();
		memberDAO.addAccount();

		System.out.println("\n\n");

		accountDAO.updateAccount();
		memberDAO.updateAccount();

		System.out.println("\n\n");

		accountDAO.deleteAccount(new Account(), true);
		memberDAO.deleteAccount();

		System.out.println("\n\n");

		accountDAO.searchAccount();
		memberDAO.searchAccount();

		System.out.println("\n\n");

		accountDAO.doWork();
		memberDAO.goToSleep();
	}
}
