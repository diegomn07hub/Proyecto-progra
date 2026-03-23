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
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "1. Agregar libro\n" +
                "2. Buscar libro\n" +
                "3. Eliminar libro\n" +
                "4. Mostrar libros\n" +
                "5. Salir"
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

            }

        } while (opcion != 5);
    }
}
   
