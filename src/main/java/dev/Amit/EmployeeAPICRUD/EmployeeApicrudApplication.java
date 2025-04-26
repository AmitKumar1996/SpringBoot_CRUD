package dev.Amit.EmployeeAPICRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;  // 👈 important
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // 👈 optional if you have repositories

@SpringBootApplication
//@EntityScan(basePackages = {"model_entity"})  // 👈 tell Spring where to find entities
public class EmployeeApicrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApicrudApplication.class, args);
		
		System.out.println("*Jay Shri Ram !!*");
	}

}
