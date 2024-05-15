package com.amal.piece;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.amal.piece.entities.Piece;
import com.amal.piece.entities.Role;
import com.amal.piece.entities.User;
import com.amal.piece.service.PieceService;
import com.amal.piece.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TheatreApplication implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	 @Autowired  
	 PasswordEncoder passwordEncoder;
	 
	 @Autowired 
		UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}
	
	 @PostConstruct 
	 void init_users() { 
	  //ajouter les rôles 
	  userService.addRole(new Role(null,"ADMIN")); 
	  userService.addRole(new Role(null,"AGENT")); 
	  userService.addRole(new Role(null,"USER")); 
	   
	  //ajouter les users 
	  userService.saveUser(new User(null,"admin","123",true,null)); 
	  userService.saveUser(new User(null,"amal","123",true,null)); 
	  userService.saveUser(new User(null,"user1","123",true,null)); 
	   
	  //ajouter les rôles aux users 
	  userService.addRoleToUser("admin", "ADMIN"); 
	   
	  userService.addRoleToUser("amal", "USER"); 
	  userService.addRoleToUser("amal", "AGENT"); 
	   
	  userService.addRoleToUser("user1", "USER");   
	 } 

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Piece.class);
//		 System.out.println("Password Encoded BCRYPT :******************** "); 
//	       System.out.println(passwordEncoder.encode("123")); 
	}

}
