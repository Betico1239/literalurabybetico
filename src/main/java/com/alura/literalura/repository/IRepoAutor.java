package com.alura.literalura.repository;

import com.alura.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRepoAutor extends JpaRepository <Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :ano AND (a.fechaMuerte IS NULL OR a.fechaMuerte >= :ano)")
    List<Autor> buscarAutoresVivos(@Param("ano") Integer ano);
}
