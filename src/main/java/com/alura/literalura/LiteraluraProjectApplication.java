package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.IRepoLibro;
import com.alura.literalura.repository.IRepoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraProjectApplication implements CommandLineRunner {

	@Autowired
	private IRepoAutor repository;

	@Autowired
	private IRepoLibro repoLibro;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal main = new Principal(repository, repoLibro);
		System.out.println("Bienvenido a Literalura, que deseas realizar el día de hoy :)");
		main.mostrarMenu();
	}
}
