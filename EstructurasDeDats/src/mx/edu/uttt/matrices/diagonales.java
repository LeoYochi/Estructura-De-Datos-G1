package mx.edu.uttt.matrices;

import javax.swing.*;

public class diagonales {

    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int filas = tamanio();
        int columnas = filas;
        int matriz[][] = new int[filas][columnas];

        int opcion = 0;
        do {
            String menu = "// Opciones Diagonal //\n"
                    + "1. Llenar aleatoriamente\n"
                    + "2. Ingresar datos manualmente\n"
                    + "0. Salir\n"
                    + "Elige una opción:";
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    llenarMatriz(matriz);
                    opcion = 0;
                    break;
                case 2:
                    llenarMatrizManual(matriz);
                    opcion = 0;
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "No se eligió ninguna opción. Se llenará aleatoriamente.");
                    llenarMatriz(matriz);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 0);

        MostrarMatriz(matriz);
        JOptionPane.showMessageDialog(null, "Suma fuera de la diagonal superior: " +
                SumarMatrisNoDiagonalSuperior(matriz));
        JOptionPane.showMessageDialog(null, "Suma fuera de la diagonal inferior: " +
                SumarMatrisNoDiagonalInferior(matriz));
    }

    public static int SumarMatrisNoDiagonalSuperior(int m[][]) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i < j) suma += m[i][j];
            }
        }
        return suma;
    }

    public static int SumarMatrisNoDiagonalInferior(int m[][]) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i > j) suma += m[i][j];
            }
        }
        return suma;
    }

    public static void MostrarMatriz(int m[][]) {
        String salida = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                salida += m[i][j] + " | ";
            }
            salida += "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    public static void llenarMatriz(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = (int) (Math.round(Math.random() * 10));
            }
        }
    }

    public static void llenarMatrizManual(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                boolean valido = false;
                do {
                    try {
                        m[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                                "Ingresa el valor para fila " + (i + 1) + ", columna " + (j + 1)));
                        valido = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
                    }
                } while (!valido);
            }
        }
    }

    public static int tamanio() {
        int valor = 0;
        boolean sentinel = true;
        do {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño de la matriz"));
                if (valor > 0) sentinel = false;
                else JOptionPane.showMessageDialog(null, "El valor debe ser mayor que cero.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
            }
        } while (sentinel);
        return valor;
    }
}
