package com.dyna.toInches;

import com.dyna.toInches.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToInchesApplication {

	private Repo repo;

	public ToInchesApplication(Repo repo) {
		this.repo = repo;
	}

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(ToInchesApplication.class, args);
	}

}
