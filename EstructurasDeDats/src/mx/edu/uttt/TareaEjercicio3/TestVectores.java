package mx.edu.uttt.TareaEjercicio3;

import javax.swing.JOptionPane;

public class TestVectores {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de elementos del vector:"));

        GestorVectores gestor = new GestorVectores(n);

        gestor.llenarVectores();
        gestor.sumarVectores();

        JOptionPane.showMessageDialog(null, gestor.obtenerVectorResultante());
    }
}
