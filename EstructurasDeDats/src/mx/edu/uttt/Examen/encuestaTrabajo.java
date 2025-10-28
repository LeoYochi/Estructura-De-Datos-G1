package mx.edu.uttt.Examen;

import javax.swing.*;
import java.util.Random;

public class encuestaTrabajo {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int n = 10;
        int[] sexo = new int[n];
        int[] trabaja = new int[n];
        int[] sueldo = new int[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            sexo[i] = rnd.nextInt(2) + 1;      // 1 = Hombre, 2 = Mujer
            trabaja[i] = rnd.nextInt(2) + 1;   // 1 = Trabaja, 2 = No trabaja
            sueldo[i] = (trabaja[i] == 1) ? rnd.nextInt(1401) + 600 : 0;
        }

        double porcentajeHombres = calcularPorcentajeSexo(sexo, 1);
        double porcentajeMujeres = calcularPorcentajeSexo(sexo, 2);
        double porcentajeHombresTrabajan = calcularPorcentajeTrabajan(sexo, trabaja, 1);
        double porcentajeMujeresTrabajan = calcularPorcentajeTrabajan(sexo, trabaja, 2);
        double promedioSueldoHombres = calcularPromedioSueldo(sexo, trabaja, sueldo, 1);
        double promedioSueldoMujeres = calcularPromedioSueldo(sexo, trabaja, sueldo, 2);

        StringBuilder sb = new StringBuilder();
        sb.append("=== ENCUESTA DE TRABAJO ===\n\n");
        sb.append("No.   Sexo        Trabaja     Sueldo\n");
        sb.append("-------------------------------------\n");

        for (int i = 0; i < n; i++) {
            String sexoStr = (sexo[i] == 1) ? "Hombre" : "Mujer";
            String trabajaStr = (trabaja[i] == 1) ? "Sí" : "No";
            String sueldoStr = (trabaja[i] == 1) ? "$" + sueldo[i] : "-";
            sb.append(String.format("%-5d%-12s%-12s%s\n", (i + 1), sexoStr, trabajaStr, sueldoStr));
        }

        sb.append("\n--- RESULTADOS GENERALES ---\n");
        sb.append(String.format("Hombres: %.1f%%\n", porcentajeHombres));
        sb.append(String.format("Mujeres: %.1f%%\n", porcentajeMujeres));
        sb.append(String.format("Hombres que trabajan: %.1f%%\n", porcentajeHombresTrabajan));
        sb.append(String.format("Mujeres que trabajan: %.1f%%\n", porcentajeMujeresTrabajan));
        sb.append(String.format("Sueldo promedio hombres: $%.2f\n", promedioSueldoHombres));
        sb.append(String.format("Sueldo promedio mujeres: $%.2f\n", promedioSueldoMujeres));

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 13));
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Resultados de Encuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double calcularPorcentajeSexo(int[] sexo, int valor) {
        int contador = 0;
        for (int s : sexo) if (s == valor) contador++;
        return (contador * 100.0) / sexo.length;
    }

    public static double calcularPorcentajeTrabajan(int[] sexo, int[] trabaja, int valorSexo) {
        int totalSexo = 0, trabajan = 0;
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == valorSexo) {
                totalSexo++;
                if (trabaja[i] == 1) trabajan++;
            }
        }
        if (totalSexo == 0) return 0;
        return (trabajan * 100.0) / totalSexo;
    }

    public static double calcularPromedioSueldo(int[] sexo, int[] trabaja, int[] sueldo, int valorSexo) {
        int total = 0, suma = 0;
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == valorSexo && trabaja[i] == 1) {
                suma += sueldo[i];
                total++;
            }
        }
        if (total == 0) return 0;
        return (double) suma / total;
    }
}
