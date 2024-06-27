package com.alura.literalura.repository;

import com.alura.literalura.models.Categoria;
import com.alura.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRepoLibro extends JpaRepository<Libro, Long> {

    List<Libro> findByIdioma(Categoria idioma);

    Optional findByTituloContainsIgnoreCase(String titulo);

}
