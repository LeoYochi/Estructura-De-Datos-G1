package mx.edu.uttt.TareaEjercicio1;

import javax.swing.JOptionPane;

public class TestProductitos {
    public static void main(String[] args) {
        int cantidad = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el número de productos a almacenar:")
        );

        GestorProductos gestor = new GestorProductos(cantidad);

        gestor.agregarProductos();

        // llamamos al método obtenerListaProductos()
        JOptionPane.showMessageDialog(null, gestor.obtenerListaProductos());
    }
}
