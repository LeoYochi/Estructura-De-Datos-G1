package mx.edu.uttt.TareaEjercicio3;

import javax.swing.JOptionPane;

public class GestorVectores {
    private double[] a;
    private double[] b;
    private double[] c;

    public GestorVectores(int n) {
        a = new double[n];
        b = new double[n];
        c = new double[n];
    }

    public void llenarVectores() {
        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor " + (i + 1) + " al vector A:"));
            b[i] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor " + (i + 1) + " al vector B:"));
        }
    }

    public void sumarVectores() {
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
    }

    public String obtenerVectorResultante() {
        String texto = "Vector resultante (C = A + B):\n";
        for (int i = 0; i < c.length; i++) {
            texto += "C[" + (i + 1) + "] = " + c[i] + "\n";
        }
        return texto;
    }
}
