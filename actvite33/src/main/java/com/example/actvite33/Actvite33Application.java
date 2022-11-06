package com.example.actvite33;

import com.example.actvite33.enitity.Customer;
import com.example.actvite33.repository.repositoryCustomer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Actvite33Application {

	public static void main(String[] args) {
		SpringApplication.run(Actvite33Application.class, args);



	}

	@Bean
	CommandLineRunner start(repositoryCustomer customerRepository){

		return args -> {

			customerRepository.save(new Customer(null,"Enset","contact@enset-media.ma"));
			customerRepository.save(new Customer(null,"FSTM","contact@fstm.ma"));
			customerRepository.save(new Customer(null,"ENSAM","contact@ensam.ma"));
			customerRepository.findAll().forEach(System.out::println);

		};

	}

}
