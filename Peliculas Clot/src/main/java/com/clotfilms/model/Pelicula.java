package com.clotfilms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peliculas")
public class Pelicula {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String genero;
    private int anyo;

    public Pelicula() {}

    public Pelicula(String titulo, String descripcion, String genero, int anyo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.genero = genero;
        this.anyo = anyo;
    }

    // Getters & Setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnyo() {
        return anyo;
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
