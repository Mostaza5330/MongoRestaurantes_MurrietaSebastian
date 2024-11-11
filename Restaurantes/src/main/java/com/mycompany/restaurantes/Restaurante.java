/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantes;

import java.util.List;

/**
 *
 * @author Sebastian Murrieta Verduzco 00000233463
 */
public class Restaurante {

    private String id;
    private String nombre;
    private List<String> categorias;
    private double rating;

    // Constructor
    public Restaurante(String nombre, List<String> categorias, double rating) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.rating = rating;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
