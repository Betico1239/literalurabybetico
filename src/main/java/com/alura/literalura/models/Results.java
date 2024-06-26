package com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(@JsonAlias("results") List<DatosLibro> librosEncontrados) {

    @Override
    public String toString() {
        return
                "librosEncontrados=" + librosEncontrados.getFirst() ;
    }

    @Override
    public List<DatosLibro> librosEncontrados() {
        return librosEncontrados;
    }
}
