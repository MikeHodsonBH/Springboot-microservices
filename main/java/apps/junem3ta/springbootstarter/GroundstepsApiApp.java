package apps.junem3ta.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroundstepsApiApp {

	public static void main(String[] args) {
		/*
		 * Sets up default configuration
		 * Starts spring configuration context
		 * Performs path scan
		 * Starts Tomcat Server
	    */
		SpringApplication.run(GroundstepsApiApp.class,args);
	}

}
