package com.srijan.blog.sbblogapp;

import com.srijan.blog.sbblogapp.config.AppConstants;
import com.srijan.blog.sbblogapp.entities.Role;
import com.srijan.blog.sbblogapp.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SbBlogAppApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SbBlogAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){ return new ModelMapper(); }


	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("12345"));

		try{
			Role role1 = new Role();
			role1.setId(AppConstants.ADMIN_USER);
			role1.setName("ADMIN_USER");

			Role role2 = new Role();
			role2.setId(AppConstants.NORMAL_USER );
			role2.setName("NORMAL_USER");

			List<Role> roles = List.of(role1, role2);

			List<Role> results = this.roleRepository.saveAll(roles);
			results.forEach(r -> {
				System.out.println(r.getName());
			});
		}catch (Exception e){
			System.out.println(e);
		}

	}
}
