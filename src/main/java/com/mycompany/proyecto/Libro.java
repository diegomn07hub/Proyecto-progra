package com.mycompany.proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashle
 */
public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidad;

    
    public Libro(String codigo, String titulo, String autor, int cantidad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }

    
    public String mostrarInfo() {
        return "Código: " + codigo +
               "\nTítulo: " + titulo +
               "\nAutor: " + autor +
               "\nCantidad: " + cantidad;
    }
}
