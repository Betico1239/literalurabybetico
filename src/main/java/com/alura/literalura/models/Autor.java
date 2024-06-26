package com.alura.literalura.models;


import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;

    @OneToMany(mappedBy = "autor" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor autor) {
        this.nombre = autor.nombre();
        this.fechaNacimiento = autor.fechaNacimiento();
        this.fechaMuerte = autor.fechaFallecimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<String> getLibros() {
        return libros.stream()
                .map(e -> e.getTitulo())
                .collect(Collectors.toList()).reversed();
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
        for (Libro libro : libros) {
            libro.setAutor(this);
        }
    }
}
