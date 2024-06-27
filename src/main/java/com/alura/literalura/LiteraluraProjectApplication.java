package com.alura.literalura;

<<<<<<< HEAD
import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.IRepoLibro;
import com.alura.literalura.repository.IRepoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
=======
>>>>>>> 6d5a055caee209bc8339ac67a0898433d62c8853
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD
public class LiteraluraProjectApplication implements CommandLineRunner {

	@Autowired
	private IRepoAutor repository;

	@Autowired
	private IRepoLibro repoLibro;
=======
public class LiteraluraProjectApplication {
>>>>>>> 6d5a055caee209bc8339ac67a0898433d62c8853

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraProjectApplication.class, args);
	}

<<<<<<< HEAD

	@Override
	public void run(String... args) throws Exception {
		Principal main = new Principal(repository, repoLibro);
		System.out.println("Bienvenido a Literalura, que deseas realizar el día de hoy :)");
		main.mostrarMenu();
	}
=======
>>>>>>> 6d5a055caee209bc8339ac67a0898433d62c8853
}
