package au.com.nab.smartchoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SmartChoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartChoiceApplication.class, args);
	}

}
