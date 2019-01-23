package com.stackroute.muzixapp;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@PropertySource("classpath:application.properties")
@Component
@SpringBootApplication

public class MuzixAppApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {


	@Value("${trackId}")
	private int trackId;
	@Value("${trackName}")
	private String trackName;
	@Value("${trackComment}")
	private String trackComment;
    @Autowired
    Environment ev;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        muzixRepository.save(new Muzix(Integer.parseInt(ev.getProperty("trackId")),ev.getProperty("trackName"),ev.getProperty("trackComment")));

    }


	public static void main(String[] args) {
		SpringApplication.run(MuzixAppApplication.class, args);
	}
	@Autowired
    MuzixRepository muzixRepository;


	@Override
	public void run(String...args) {
	    muzixRepository.save(new Muzix(1, "Sajal", "name"));
    }





}

