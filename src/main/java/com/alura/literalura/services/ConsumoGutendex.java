package com.alura.literalura.services;

import ch.qos.logback.core.model.processor.NOPModelHandler;
import com.alura.literalura.models.DatosLibro;
import com.alura.literalura.models.Results;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsumoGutendex {

    private ConvertidorDatos conversor = new ConvertidorDatos();
    private static final String URL_BASE = "https://gutendex.com/books/?search=";



    public String obtenerDatos(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

    public DatosLibro procesarUrl(String nombre){

        var url = URL_BASE  + URLEncoder.encode(nombre, StandardCharsets.UTF_8);

        var json = obtenerDatos(url);//Datos del response

        //System.out.println("Datos de la api : " + json);

        //procesarlos

        var datos = conversor.obtenerDatos(json, Results.class);

        var primerLibroEncontrado = conversor.obtenerDatos(json,Results.class).librosEncontrados().getFirst();
        return primerLibroEncontrado;
    }


}
