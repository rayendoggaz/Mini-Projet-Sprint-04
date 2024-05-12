package com.rayen.concerts;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.entities.Role;
import com.rayen.concerts.entities.User;
import com.rayen.concerts.service.ConcertService;
import com.rayen.concerts.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ConcertsApplication implements CommandLineRunner {

	@Autowired
	ConcertService concertService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ConcertsApplication.class, args);
	}

	/*
	@PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));
		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "rayen", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));
		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("rayen", "USER");
		userService.addRoleToUser("rayen", "AGENT");
		userService.addRoleToUser("user1", "USER");
	}
	*/

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		//repositoryRestConfiguration.exposeIdsFor(Concert.class);
	}

}
