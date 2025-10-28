package mx.edu.uttt.TareaEjercicio2;

import javax.swing.JOptionPane;

public class GestorValores {
    private double[] valores;

    public GestorValores(int cantidad) {
        valores = new double[cantidad];
    }

    public void llenarValores() {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el valor " + (i + 1) + ":")
            );
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double v : valores) {
            suma += v;
        }
        return suma / valores.length;
    }

    public int contarMayores(double promedio) {
        int contador = 0;
        for (double v : valores) {
            if (v > promedio) {
                contador++;
            }
        }
        return contador;
    }

    public String listaMayores(double promedio) {
        String texto = "";
        for (double v : valores) {
            if (v > promedio) {
                texto += v + "\n";
            }
        }
        return texto.isEmpty() ? "No hay valores mayores" : texto;
    }
}
