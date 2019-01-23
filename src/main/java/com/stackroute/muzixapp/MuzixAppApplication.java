package com.stackroute.muzixapp;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication

public class MuzixAppApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MuzixAppApplication.class, args);
	}
	@Autowired
   MuzixRepository muzixRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		muzixRepository.save(new Muzix(1,"Shilpa","error"));
	}

	@Override
	public void run(String...args) {
		muzixRepository.save(new Muzix(2,"Sajal","highfive"));
	}


}

