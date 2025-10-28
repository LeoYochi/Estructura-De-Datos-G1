package mx.edu.uttt.Examen;

import javax.swing.*;

public class calificaciones {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int examenes = 5;
        int N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estudiantes:"));
        double[][] calificaciones = new double[N][examenes];

        // Ingreso de datos
        for (int i = 0; i < N; i++) {
            JOptionPane.showMessageDialog(null, "ingresa las calificaciones de los estudiantes ");
            for (int j = 0; j < examenes; j++) {
                calificaciones[i][j] = Double.parseDouble(JOptionPane.showInputDialog(
                        "Estudiante " + (i + 1) + " en el examen " + (j + 1) + ":"));
            }
        }

        double[] promedioEstudiante = calcularPromedioEstudiantes(calificaciones);
        String mejoresTercer = mejoresEnExamen(calificaciones, 2);
        String mejoresPrimeroQuinto = mejoresEnPrimeroYQuinto(calificaciones);
        int examenMasAlto = examenConMejorPromedio(calificaciones);

        StringBuilder salida = new StringBuilder();
        salida.append("=== REPORTE DE CALIFICACIONES ===\n\n");
        salida.append("Estudiante     Ex1   Ex2   Ex3   Ex4   Ex5   Promedio\n");
        salida.append("------------------------------------------------------\n");

        for (int i = 0; i < N; i++) {
            salida.append(String.format("Alumno %-4d", (i + 1)));
            for (int j = 0; j < examenes; j++) {
                salida.append(String.format("%6.1f", calificaciones[i][j]));
            }
            salida.append(String.format("%10.2f\n", promedioEstudiante[i]));
        }

        salida.append("\nMejor en el 3er examen:\n").append(mejoresTercer);
        salida.append("\nMejor en el 1er y 5to examen:\n").append(mejoresPrimeroQuinto);
        salida.append("\nExamen con mejor promedio: ").append(examenMasAlto + 1);

        JTextArea textArea = new JTextArea(salida.toString());
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 13));
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double[] calcularPromedioEstudiantes(double[][] calificaciones) {
        double[] promedios = new double[calificaciones.length];
        for (int i = 0; i < calificaciones.length; i++) {
            double suma = 0;
            for (int j = 0; j < calificaciones[i].length; j++) {
                suma += calificaciones[i][j];
            }
            promedios[i] = suma / calificaciones[i].length;
        }
        return promedios;
    }

    public static String mejoresEnExamen(double[][] calificaciones, int examen) {
        double max = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i][examen] > max) {
                max = calificaciones[i][examen];
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i][examen] == max) {
                resultado.append("Alumno ").append(i + 1).append(" con ").append(String.format("%.2f", max)).append("\n");
            }
        }
        return resultado.toString();
    }

    public static String mejoresEnPrimeroYQuinto(double[][] calificaciones) {
        double max1 = 0, max5 = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i][0] > max1) max1 = calificaciones[i][0];
            if (calificaciones[i][4] > max5) max5 = calificaciones[i][4];
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i][0] == max1 && calificaciones[i][4] == max5) {
                resultado.append("Alumno ").append(i + 1)
                        .append(" (1er: ").append(String.format("%.2f", max1))
                        .append(", 5to: ").append(String.format("%.2f", max5)).append(")\n");
            }
        }

        if (resultado.isEmpty()) {
            resultado.append("Ningún alumno tuvo la mayor calificación en ambos.\n");
        }
        return resultado.toString();
    }

    public static int examenConMejorPromedio(double[][] calificaciones) {
        double[] promedioExamen = new double[5];
        for (int j = 0; j < 5; j++) {
            double suma = 0;
            for (int i = 0; i < calificaciones.length; i++) {
                suma += calificaciones[i][j];
            }
            promedioExamen[j] = suma / calificaciones.length;
        }

        int indiceMayor = 0;
        for (int j = 1; j < 5; j++) {
            if (promedioExamen[j] > promedioExamen[indiceMayor]) {
                indiceMayor = j;
            }
        }
        return indiceMayor;
    }
}
