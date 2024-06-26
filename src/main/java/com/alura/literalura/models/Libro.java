package com.alura.literalura.models;

import jakarta.persistence.*;
import jdk.jfr.Category;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Categoria idioma;
    private Integer descargas;
    private String escritor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(DatosLibro libro, Autor autor) {
        this.titulo = libro.titulo();

        this.idioma = Categoria.fromString(libro.idioma().getFirst());

        this.descargas = libro.descargas();

        this.escritor = libro.autor().getFirst().nombre();

        this.autor = autor;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getIdioma() {
        return idioma;
    }

    public void setIdioma(Categoria idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEscritor() {
        return escritor;
    }

    @Override
    public String toString() {
        return "---------LIBRO----------\n" +
                "Título: " + getTitulo() +"\n" +
                "Autor: " + getEscritor() + "\n" +
                "Idioma: " + getIdioma() + "\n" +
                "Descargas: " + getDescargas() + "\n" +
                "-------------------------";

    }
}
