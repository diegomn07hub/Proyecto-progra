/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avancefinal;

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Avancefinal {

    public static void main(String[] args) {
    

String entrada = JOptionPane.showInputDialog("Cuantos usuarios desea ingresar?");
        int cantidad = Integer.parseInt(entrada);

        String baseDeDatosEstudiantes = ""; 

        for (int i = 0; i < cantidad; i++) {
            
            JOptionPane.showMessageDialog(null, "Registro del usuario #" + (i + 1));

            Usuario miembro = new Usuario();
            miembro.registrarMiembro();
            
            baseDeDatosEstudiantes += miembro.obtenerResumen(i + 1);
            
            miembro.mostrarDatos(); 
        }


        JOptionPane.showMessageDialog(null, "--- REGISTROS COMPLETOS EN MEMORIA ---\n" + 
                                      baseDeDatosEstudiantes);
    }
}