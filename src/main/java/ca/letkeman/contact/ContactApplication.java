package ca.letkeman.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApplication {

	// http://localhost:8080/swagger-ui/index.html
	// http://localhost:8080/spotlight/index.html
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

}
