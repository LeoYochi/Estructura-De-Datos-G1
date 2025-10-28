package mx.edu.uttt.matrices;
import mx.edu.uttt.matrices.diagonales;

import javax.swing.*;

public class menuOperaciones {
    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));

        OperacionesMatrices op = new OperacionesMatrices(filas, columnas);

        double[][] datos = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor [" + i + "][" + j + "]:"));
            }
        }
        op.setM(datos);

        int opcion;
        do {
            String menu = """

        ==   Holaaaa, este es mi menu ==  
            ->   ¿En que puedo ayudarte?  <-
                   
  1-  Imprimie matriz                         
  2-  Suma las filas y columnas                  
  3-  Suma la diagonal principal                
  4-  Suma la diagonal inversa (modelo 1)      
  5-  Suma la diagonal inversa (modelo 2)      
  6-  Suma la diagonal inversa (modelo 3)      
  7-  Suma la diagonal inversa (modelo 4)      
  8-  Calcula la transpuesta                    
  9-  Suma dos matrices                      
 10-  Resta dos matrices                     
 11-  Multiplica dos matrices                
 12-  Suma de el contrario diagonal           
 13-  Ingresar palabras B)
 14-  Ponerle margen :0      
           ¿Quieres Salir? :(
  0-  Salir                                   
""";


            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nElija una opción:"));

            try {
                switch (opcion) {
                    case 1 -> op.imprimir();
                    case 2 -> JOptionPane.showMessageDialog(null, op.imprimirSumaColumnasFilas());
                    case 3 -> JOptionPane.showMessageDialog(null, "Suma de diagonal principal: " + op.sumarDiagonal());
                    case 4 -> JOptionPane.showMessageDialog(null, "Suma de inversa metodo 1: " + op.sumarDiagonalInversa());
                    case 5 -> JOptionPane.showMessageDialog(null, "Suma de inversa metodo 2: " + op.sumarDiagonalInversa2());
                    case 6 -> JOptionPane.showMessageDialog(null, "Suma de inversa metodo 3: " + op.sumarDiagonalInversa3());
                    case 7 -> JOptionPane.showMessageDialog(null, "Suma de inversa metodo 4: " + op.sumarDiagonalInversa4());
                    case 8 -> {
                        double[][] t = new double[columnas][filas];
                        op.calcularTranspuesta(op.getM(), t);
                        op.imprimir();
                    }
                    case 9 -> {
                        double[][] m1 = pedirMatriz(filas, columnas, "primera");
                        double[][] m2 = pedirMatriz(filas, columnas, "segunda");
                        op.sumarMatrices(m1, m2);
                        op.imprimir();
                    }
                    case 10 -> {
                        double[][] m1 = pedirMatriz(filas, columnas, "primera");
                        double[][] m2 = pedirMatriz(filas, columnas, "segunda");
                        op.restarMatrices(m1, m2);
                        op.imprimir();
                    }
                    case 11 -> {
                        int c2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas de la segunda matriz:"));
                        double[][] m1 = pedirMatriz(filas, columnas, "primera");
                        double[][] m2 = pedirMatriz(columnas, c2, "segunda");
                        op.multiplicarMatrices(m1, m2);
                        op.imprimir();
                    }
                    case 12 ->{
                        diagonales.iniciar();

                    }
                    case 13 ->{
                        letras.iniciar();
                    }
                    case 14 ->{
                        margen.iniciar();
                    }

                    case 0 -> JOptionPane.showMessageDialog(null, "Nos vemos!, espero y vuelvas pronto :(");
                    default -> JOptionPane.showMessageDialog(null, "opcion no valida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }
    private static double[][] pedirMatriz(int filas, int columnas, String nombre) {
        double[][] matriz = new double[filas][columnas];
        JOptionPane.showMessageDialog(null, "Ingrese los datos de la " + nombre + " matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog("[" + i + "][" + j + "]:"));
            }
        }
        return matriz;
    }
}
