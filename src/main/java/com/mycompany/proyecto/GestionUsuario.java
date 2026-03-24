/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class GestionUsuario {
    private String nombre;
    private String correo;
    private String identificacion;

    public GestionUsuario() {
    }

    public GestionUsuario(String nombre, String correo, String identificacion) {
        this.nombre = nombre;
        this.correo = correo;
        this.identificacion = identificacion;
    }

    public void registrarMiembro() {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        correo = JOptionPane.showInputDialog("Ingrese el correo del usuario:");
        identificacion = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");
    }

    public String obtenerResumen(int numero) {
        return "Usuario #" + numero +
               "\n Nombre: " + nombre +
               "\n Correo: " + correo +
               "\n Identificación: " + identificacion + "\n";
    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null,
            "Nombre: " + nombre +
            "\n Correo: " + correo +
            "\n Identificación: " + identificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
