package mx.edu.uttt.ejercicios;

import javax.swing.*;

public class TestProductoVector {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de productos:"));
        ProductoVector pv = new ProductoVector(tamanio);
        boolean sentinel = true;

        do {
            String opcion = JOptionPane.showInputDialog(menu());

            switch (opcion) {
                case "1": // agregar todos los productos de una vez
                    for (int i = 0; i < tamanio; i++) {
                        Producto nuevo = llenarProducto(i + 1);
                        pv.agregar(nuevo);
                    }
                    JOptionPane.showMessageDialog(null, "Todos los productos fueron registrados.");
                    break;

                case "2": // imprimir
                    JOptionPane.showMessageDialog(null, pv.imprimir());
                    break;

                case "3": // eliminar
                    String nombreE = JOptionPane.showInputDialog("Introduce el nombre del producto a eliminar:");
                    if (pv.eliminar(nombreE)) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    break;

                case "4": // editar
                    String nombreM = JOptionPane.showInputDialog("Introduce el nombre del producto a modificar:");
                    String campo = JOptionPane.showInputDialog("¿Qué deseas modificar? (nombre/precio/stock)");
                    String nuevoValor = JOptionPane.showInputDialog("Introduce el nuevo valor:");
                    if (pv.modificar(nombreM, campo, nuevoValor)) {
                        JOptionPane.showMessageDialog(null, "Producto modificado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: producto o campo no encontrado.");
                    }
                    break;

                case "5": // salir
                    sentinel = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (sentinel);
    }

    public static String menu() {
        return "Menu Principal \n" +
                "1) Agregar productos\n" +
                "2) Imprimir productos\n" +
                "3) Eliminar producto\n" +
                "4) Editar producto\n" +
                "5) Salir\n" +
                "Elegir opción:";
    }


    public static Producto llenarProducto(int num) {
        String nombre = JOptionPane.showInputDialog("Producto " + num + " - Nombre:");
        int existencia = Integer.parseInt(JOptionPane.showInputDialog("Producto " + num + " - Stock:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Producto " + num + " - Precio:"));
        return new Producto(nombre, precio, existencia);
    }
}
