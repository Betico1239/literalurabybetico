package com.alura.literalura.models;

public enum Categoria {

    ESPANOL("es", "español"),
    INGLES("en", "inglés"),
    FRANCES("fr", "francés"),
    PORTUGUES("pt", "portugués"),
    FINLANDES("fi", "finlandés");

    private String categoriaGutendex;
    private String getCategoriaUsuario;
    Categoria(String categoriaGutendex, String getCategoriaUsuario) {
        this.categoriaGutendex = categoriaGutendex;
        this.getCategoriaUsuario = getCategoriaUsuario;
    }

    public static Categoria fromString(String text){
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaGutendex.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Categoria fromUser(String text){
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getCategoriaUsuario.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
