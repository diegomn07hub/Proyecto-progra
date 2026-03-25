/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancefinal;
import javax.swing.JOptionPane;
/**
 *
 * @author andre
 */
public class Usuario {

    public String nombre;
    public String correo;
    private String contrasenia;
    public String rol;

    public Usuario() {
        this.nombre = "";
        this.correo = "";
        this.contrasenia = "";
        this.rol = "";
    }

    public void registrarMiembro() {
        this.nombre = JOptionPane.showInputDialog("Nombre del nuevo miembro:");
        this.correo = JOptionPane.showInputDialog("Correo electronico:");
        this.rol = JOptionPane.showInputDialog("Rol en el sistema:");
        
        String nuevaPass = JOptionPane.showInputDialog("Elija su contrasenia (mínimo 8 caracteres):");
        
        if (nuevaPass.length() >= 8) {
            this.contrasenia = nuevaPass;
        } else {
            this.contrasenia = "Error: Corta";
            JOptionPane.showMessageDialog(null, "Alerta: La contrasenia es muy corta.");
        }
    }

    public String obtenerResumen(int id) {
        return "ID: " + id + " | Nombre: " + nombre + " | Correo: " + correo + "\n";
    }
    
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, "Usuario registrado: " + nombre);
    }

}


 
    

