package com.example.argreadjointpoint;

import com.example.argreadjointpoint.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArgReadJointpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgReadJointpointApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");

		theAccountDAO.addAccount(account, true);


		theAccountDAO.setName("foobar");
//		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
//		String code = theAccountDAO.getServiceCode();


	}
}
