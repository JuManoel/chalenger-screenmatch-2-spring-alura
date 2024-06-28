package edu.alura.famousphrases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.alura.famousphrases.repository.SerieFilmeRepository;

@SpringBootApplication
public class FamousphrasesApplication{

	@Autowired
	SerieFilmeRepository repository;

	public static void main(String[] args)  {
		SpringApplication.run(FamousphrasesApplication.class, args);
	}


}
