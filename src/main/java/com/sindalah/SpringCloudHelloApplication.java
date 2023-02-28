package com.sindalah;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.sindalah.entity.Contact;
import com.sindalah.repository.ContactRepository;

@SpringBootApplication
public class SpringCloudHelloApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHelloApplication.class, args);
	}

	// Adding data into contacts table in H2DB
	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(
					i -> new Contact(i, "Contact " + i, "contact" + i + "@email.com", "(111) 111-111" + i + ")"))
					.map(v -> repository.save(v)).forEach(System.out::println);
		};
	}
}
