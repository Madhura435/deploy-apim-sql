package com.azure.deployapimmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DeployApimMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployApimMysqlApplication.class, args);
	}

	// In this project we are also doing azure App service with deployment. Here we are  in built Azure
	// AD integration of app service.
	// logout url for web app https://webapp-auth.azurewebsites.net/.auth/logout
}
