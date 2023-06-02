package br.com.lsant.postApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PostApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApiApplication.class, args);
	}

}
