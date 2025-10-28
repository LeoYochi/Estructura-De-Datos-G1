package mx.edu.uttt.TareaEjercicio1;

import javax.swing.JOptionPane;

public class GestorProductos {
    private Producto[] productos;

    public GestorProductos(int cantidad) {
        productos = new Producto[cantidad];
    }

    public void agregarProductos() {
        for (int i = 0; i < productos.length; i++) {
            String nombre = JOptionPane.showInputDialog("Producto " + (i + 1) + "\nNombre:");
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Producto " + (i + 1) + "\nStock:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Producto " + (i + 1) + "\nPrecio:"));

            productos[i] = new Producto(nombre, stock, precio);
        }
    }

    // 🔹 Método que devuelve un String con todos los productos
    public String obtenerListaProductos() {
        String texto = "--- Lista de Productos ---\n\n";
        for (Producto p : productos) {
            texto += "Nombre: " + p.getNombre() + "\n";
            texto += "Stock: " + p.getStock() + "\n";
            texto += "Precio: " + p.getPrecio() + "\n";
            texto += "Importe: " + p.calcularImporte() + "\n";
            texto += "------------------------\n";
        }
        return texto;
    }
}
