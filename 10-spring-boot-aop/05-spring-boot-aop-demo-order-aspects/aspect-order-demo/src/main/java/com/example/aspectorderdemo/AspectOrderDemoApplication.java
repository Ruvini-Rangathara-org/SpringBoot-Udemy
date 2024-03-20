package com.example.aspectorderdemo;

import com.example.aspectorderdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrderDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

		theAccountDAO.addAccount(new Account(), true);
//		theAccountDAO.doWork();

		theAccountDAO.setName("foobar");
//		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
//		String code = theAccountDAO.getServiceCode();


	}
}
