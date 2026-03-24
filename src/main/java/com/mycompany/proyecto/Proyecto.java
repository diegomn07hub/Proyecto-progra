/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;
import javax.swing.JOptionPane;
/**
 *
 * @author ashle
 */
public class Proyecto {

    public static void main(String[] args) {
        InventarioLibros inventario = new InventarioLibros(100);
        ModuloOperaciones modulo = new ModuloOperaciones(100);
        GestionUsuario[] usuarios = new GestionUsuario[100];
        int contadorUsuarios = 0;
       
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n" +
                "1. Agregar libro\n" +
                "2. Buscar libro\n" +
                "3. Eliminar libro\n" +
                "4. Mostrar libros\n" +
                "5. Registrar usuario\n" +
                "6. Mostrar usuarios\n" +
                "7. Prestar libro\n" +
                "8. Devolver libro\n" +
                "9. Mostrar préstamos\n" +
                "10. Salir"
            ));

            switch (opcion) {
                case 1:
                    String codigo = JOptionPane.showInputDialog("Código:");
                    String titulo = JOptionPane.showInputDialog("Título:");
                    String autor = JOptionPane.showInputDialog("Autor:");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                    Libro libro = new Libro(codigo, titulo, autor, cantidad);
    
                    boolean agregado = inventario.agregarLibro(libro);
                    if (agregado) {
                        JOptionPane.showMessageDialog(null, "Libro agregado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar (sin espacio)");
                    }
                   
                    break;

                case 2:
                    codigo = JOptionPane.showInputDialog("Ingrese código:");
                    Libro encontrado = inventario.buscarLibro(codigo);

                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, encontrado.mostrarInfo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado");
                    }
                    break;

                case 3:
                    codigo = JOptionPane.showInputDialog("Código a eliminar:");
                    boolean eliminado = inventario.eliminarLibro(codigo);

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Libro eliminado");
                         inventario.mostrarLibros();
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe el libro");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, inventario.mostrarLibros());
                    break;
            
                case 5: //Gestion de usuarios 
                    if(contadorUsuarios < usuarios.length) {
                        GestionUsuario usuario = new GestionUsuario();
                        usuario.registrarMiembro();

                        usuarios[contadorUsuarios] = usuario;
                        contadorUsuarios++;

                        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacio para más usuarios");
                    }
                    break;

                case 6:
                    if (contadorUsuarios == 0) {
                        JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
                    } else {
                        String listaUsuarios = "";

                        for (int i = 0; i < contadorUsuarios; i++) {
                            listaUsuarios += usuarios[i].obtenerResumen(i + 1) + "\n";
                        }

                        JOptionPane.showMessageDialog(null, listaUsuarios);
                    }
                    break;
                    
                case 7:

                    if (contadorUsuarios == 0) {
                        JOptionPane.showMessageDialog(null, "Primero debe registrar usuarios");
                        break;
                    }

                    String idUsuario = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");

                    GestionUsuario usuarioPrestamo = null;

                    // Busca el usuario por identificación
                    for (int i = 0; i < contadorUsuarios; i++) {
                        if (usuarios[i].getIdentificacion().equals(idUsuario)) {
                            usuarioPrestamo = usuarios[i];
                            break;
                        }
                    }

                    if (usuarioPrestamo == null) {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                        break;
                    }

                    codigo = JOptionPane.showInputDialog("Ingrese código del libro a prestar:");
                    Libro libroPrestamo = inventario.buscarLibro(codigo);

                    if (libroPrestamo == null) {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado");
                    } else {

                        if (modulo.prestarLibro(usuarioPrestamo, libroPrestamo)) {
                            JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "El libro no está disponible");
                        }
                    }
                    break;
                
                //Modulo de devolucion de libros    
                case 8:
                    codigo = JOptionPane.showInputDialog("Ingrese código del libro a devolver:");

                    if (modulo.devolverLibro(codigo)) {
                        JOptionPane.showMessageDialog(null, "Libro devuelto correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un préstamo activo para ese libro");
                    }
                    break;
                    
                case 9:
                    JOptionPane.showMessageDialog(null, modulo.mostrarPrestamos());
                    break;

                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 10);
    }
}
   
