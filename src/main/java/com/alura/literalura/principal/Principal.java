package com.alura.literalura.principal;

import com.alura.literalura.models.Autor;
import com.alura.literalura.models.Categoria;
import com.alura.literalura.models.Libro;
import com.alura.literalura.repository.IRepoLibro;
import com.alura.literalura.repository.IRepoAutor;
import com.alura.literalura.services.ConsumoGutendex;
import org.hibernate.exception.ConstraintViolationException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoGutendex consumoGutendex = new ConsumoGutendex();

    private IRepoAutor repoAutor;
    private IRepoLibro repoLibro;

    private int opcion;

    public Principal(IRepoAutor repository, IRepoLibro repoLibro) {
        this.repoAutor = repository;
        this.repoLibro = repoLibro;
    }

    public void mostrarMenu(){
        opcion = -1;

        while (opcion != 0) {
            try {
                var menu = """
                    1 - Buscar libro por título\s
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
               \s
                    0 - Salir
                   \s""";
                System.out.println(menu);
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        obtenerLibro();
                        break;
                    case 2:
                        // Acción para listar libros registrados
                        obtenerLibrosRegistrados();
                        break;
                    case 3:
                        // Acción para listar autores registrados
                        obtenerAutoresRegistrados();
                        break;
                    case 4:
                        // Acción para listar autores vivos en determinado año
                        obtenerAutoresPorFecha();
                        break;
                    case 5:
                        // Acción para listar libros por idioma
                        obtenerLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es correcto. Por favor, ingrese un número.");
            } catch (IllegalStateException e) {
                System.out.println("Error de inserción");
                System.out.println(e.getMessage());
            }
             finally {
                if (opcion == 0) {
                    System.out.println("Ten un lindo día");
                    teclado.close();
                }
            }
        }

    }

    private void obtenerLibrosPorIdioma() {

        try {
            System.out.println("""
                De cuál categoría deseas realizar tú busqueda:
                -> Español
                -> Inglés
                -> Francés
                -> Portugués
                """);

            var idioma = Categoria.fromUser(teclado.nextLine());

            List<Libro> librosPorIdioma = repoLibro.findByIdioma(idioma);

            librosPorIdioma.stream()
                    .forEach(e -> System.out.println(
                            "---------LIBRO----------\n" +
                                    "Título: " + e.getTitulo() +"\n" +
                                    "Autor: " + e.getEscritor() + "\n" +
                                    "Idioma: " + e.getIdioma() + "\n" +
                                    "Descargas: " + e.getDescargas() + "\n" +
                                    "-------------------------"
                    ));
        }catch (Exception e){
            System.out.println("Debes escribir bien la categoría");
        }
    }

    private void obtenerAutoresPorFecha() {
        Integer ano = null;

        while (ano == null) {
            System.out.print("Introduce el año en que deseas buscar tu(s) autor(es): ");
            try {
                ano = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        }
        List<Autor> autoresVivitos = repoAutor.buscarAutoresVivos(ano);

        if (autoresVivitos.isEmpty()){
            System.out.println("No existen autores registrados que hayan vivido en esa época");
        }else {
            autoresVivitos.stream()
                    .forEach(e -> System.out.println(
                            "---------AUTOR----------\n" +
                                    "Nombre: " + e.getNombre() +"\n" +
                                    "Año de Nacimiento: " + e.getFechaNacimiento() + "\n" +
                                    "Año de Muerte: " + e.getFechaMuerte() + "\n" +
                                    "Libros registrados: " + e.getLibros() + "\n" +
                                    "-------------------------"));
        }
    }

    private void obtenerAutoresRegistrados() {

        var autores = repoAutor.findAll();

        autores.stream()
                .forEach(e -> System.out.println(
                        "---------AUTOR----------\n" +
                                "Nombre: " + e.getNombre() +"\n" +
                                "Año de Nacimiento: " + e.getFechaNacimiento() + "\n" +
                                "Año de Muerte: " + e.getFechaMuerte() + "\n" +
                                "Libros registrados: " + e.getLibros() + "\n" +
                                "-------------------------"
                ));
    }

    private void obtenerLibrosRegistrados() {
        var lista = repoLibro.findAll();

        lista.stream()
                .forEach(e -> System.out.println(
                        "---------LIBRO----------\n" +
                                "Título: " + e.getTitulo() +"\n" +
                                "Autor: " + e.getEscritor() + "\n" +
                                "Idioma: " + e.getIdioma() + "\n" +
                                "Descargas: " + e.getDescargas() + "\n" +
                                "-------------------------"
                ));
    }

    private void obtenerLibro() {

        System.out.println("Cuál es el nombre del libro que deseas consultar?");
        var name = teclado.nextLine();

        Optional libroConsultaPrevia = repoLibro.findByTituloContainsIgnoreCase(name);

        if (!libroConsultaPrevia.isPresent()){
            var ex = consumoGutendex.procesarUrl(name);

            var autores = ex.autor();

            //agregarlo a la base de datos

            Autor autor = repoAutor.findByNombre(autores.getFirst().nombre())
                    .orElseGet(() -> {
                        Autor nuevoAutor = new Autor(autores.getFirst());
                        return repoAutor.save(nuevoAutor);
                    });

            Libro libro = new Libro(ex, autor);

            repoLibro.save(libro);
            //Mostrar el libro agregado
            System.out.println(libro);

        }else {
            System.out.println("El libro que buscas ya se ha registrado previamente");

        }

    }
}
