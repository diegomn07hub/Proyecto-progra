package com.mycompany.proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashle
 */
public class InventarioLibros {
    
    private Libro[] libros;
    private int contador;
    private int capacidad;

   public InventarioLibros() {
    }

    
    public InventarioLibros(int capacidad) {
        this.capacidad = capacidad;
        libros = new Libro[capacidad];
        contador = 0;
    } 
   
    public boolean agregarLibro(Libro libro) {
        if (contador < capacidad) {
            libros[contador] = libro;
            contador++;
            return true;
        } else {
            return false; 
        }
    }

    
    public Libro buscarLibro(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (libros[i].getCodigo().equals(codigo)) {
                return libros[i];
            }
        }
        return null;
    }

    
    public boolean eliminarLibro(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (libros[i].getCodigo().equals(codigo)) {               
                for (int j = i; j < contador - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                libros[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    
    public String mostrarLibros() {
        if (contador == 0) {
            return "No hay libros en el inventario.";
        }

        String resultado = "";
        for (int i = 0; i < contador; i++) {
            resultado += libros[i].mostrarInfo() + "\n\n";
        }
        return resultado;
    }
}

