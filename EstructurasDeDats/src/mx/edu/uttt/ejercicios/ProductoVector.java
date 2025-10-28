package mx.edu.uttt.ejercicios;

import javax.swing.*;

public class ProductoVector {
    private Producto[] productos;
    private int contador; // productos almacenados

    public ProductoVector(int tamanio) {
        if (tamanio <= 0) {
            this.productos = new Producto[1];
        } else {
            this.productos = new Producto[tamanio];
        }
        this.contador = 0;
    }

    // Agregar producto al vector
    public boolean agregar(Producto p) {
        if (contador < productos.length) {
            productos[contador] = p;
            contador++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El vector    lleno.");
            return false;
        }
    }

    // Imprimir productos
    public String imprimir() {
        if (contador == 0) {
            return "No hay productos registrados.\n";
        }

        String salida = "Lista de productos:\n";
        for (int i = 0; i < contador; i++) {
            Producto p = productos[i];
            double importe = p.getPrecio() * p.getStock();
            salida += (i + 1) + ". " + p.toString() + " | Importe: " + importe + "\n";
        }
        return salida;
    }

    // Buscar producto por nombre (retorna índice o -1 si no existe)
    public int buscar(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // Eliminar producto por nombre
    public boolean eliminar(String nombre) {
        int pos = buscar(nombre);
        if (pos != -1) {
            for (int i = pos; i < contador - 1; i++) {
                productos[i] = productos[i + 1];
            }
            productos[contador - 1] = null;
            contador--;
            return true;
        }
        return false;
    }

    // Modificar producto
    public boolean modificar(String nombre, String campo, String nuevoValor) {
        int pos = buscar(nombre);
        if (pos != -1) {
            Producto p = productos[pos];
            switch (campo.toLowerCase()) {
                case "nombre":
                    p.setNombre(nuevoValor);
                    break;
                case "precio":
                    p.setPrecio(Double.parseDouble(nuevoValor));
                    break;
                case "stock":
                    p.setStock(Integer.parseInt(nuevoValor));
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }
}
