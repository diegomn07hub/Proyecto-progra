package com.mycompany.proyecto;


import java.util.Date;

//Clase prestamo, muestra la relacion entre el usuario y el libro prestado
class Prestamo {
    private GestionUsuario usuario; //usuario que pide el prestamo
    private Libro libro; //libro prestado
    private Date fechaPrestamo; //fecha del prestamo
    private Date fechaDevolucion; //fecha de devolucion

//Constructor que se ejecuta cuando se crea un nuevo prestamo
    public Prestamo(GestionUsuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = new Date(); //guarda la fecha automaticamente
        this.fechaDevolucion = null; 
    }

//Gets para acceder ala informacion del prestamo
    public GestionUsuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

//Set para registar la fecha de devolucion del libro
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

//Muestra la informacion completa del prestamos
    public String mostrarPrestamo() {
        return "Usuario: \n" + usuario.getNombre() +
               "Libro: \n" + libro.getTitulo() +
               "Fecha préstamo: \n" + fechaPrestamo +
               "Fecha devolución: \n" + (fechaDevolucion == null ? "Pendiente" : fechaDevolucion);
    }
}

//Clase Modulo operaciones para gestionar los prestamos y devoluciones
public class ModuloOperaciones {

    private Prestamo[] prestamos; // arreglo de préstamos
    private int contador;         // cantidad actual
    private int capacidad;        // tamaño máximo

    //Constructor ModuloOperaciones
    public ModuloOperaciones(int capacidad) {
        this.capacidad = capacidad;
        prestamos = new Prestamo[capacidad];
        contador = 0;
    }

//Gestion de prestamo de libro
    public boolean prestarLibro(GestionUsuario usuario, Libro libro) {
        
        if (contador >= capacidad) { // Valida el espacio en el arreglo
            return false;
        }
        
        if (libro != null && libro.isDisponible()) { // Valida la disponibilidad del libro
            Prestamo nuevo = new Prestamo(usuario, libro);
            prestamos[contador] = nuevo;
            contador++;
            libro.setDisponible(false);
            return true;
        }
        return false;
    }

//Gestion de devoluciones de libros
    public boolean devolverLibro(String codigoLibro) {
        for (int i = 0; i < contador; i++) {
            Prestamo prestamo = prestamos[i];
            if (prestamo.getLibro().getCodigo().equals(codigoLibro) && prestamo.getFechaDevolucion() == null) {
                prestamo.setFechaDevolucion(new Date());
                prestamo.getLibro().setDisponible(true);
                return true;
            }
        }
        return false;
    }

//Muestra todos los prestamos
    public String mostrarPrestamos() {
        if (contador == 0) {
            return "No hay préstamos registrados.";
        }

        String resultado = "";

        for (int i = 0; i < contador; i++) {
            resultado += "Préstamo #" + (i + 1) + "\n";
            resultado += prestamos[i].mostrarPrestamo() + "\n\n";
        }
        return resultado;
    }
}