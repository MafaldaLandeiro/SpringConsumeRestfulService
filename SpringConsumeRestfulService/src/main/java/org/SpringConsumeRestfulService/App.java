package org.SpringConsumeRestfulService;

import org.SpringConsumeRestfulService.response.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static String name = "Mafalda";

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		Greeting greet = restTemplate.getForObject(
				"http://localhost:8080/getGreeting?name=".concat(name), Greeting.class);
		log.info(greet.toString());
	}
}
