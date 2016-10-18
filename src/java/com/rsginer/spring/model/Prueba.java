/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.model;

/**
 *
 * @author Rubén
 */
public class Prueba {
    
    private String nombre;
    private int numero;

    public Prueba(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
