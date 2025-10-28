package mx.edu.uttt.matrices;

import javax.swing.*;

public class TestOperacionesMatrices{
    public static void main(String[] args) {
        iniciar();
    }
    public static void iniciar(){
        int filas = obtenerTamanio();
        int columnas = obtenerTamanio();
        OperacionesMatrices oper = new OperacionesMatrices(filas, columnas);

        double [][] m = new double[filas][columnas];


        llenarMatriz(m);
        oper.setM(m);

        oper.imprimir();
        try {
            JOptionPane.showMessageDialog(null,oper.sumarDiagonal());
            JOptionPane.showMessageDialog(null,oper.sumarDiagonal2());
            JOptionPane.showMessageDialog(null,oper.sumarDiagonalInversa());
            JOptionPane.showMessageDialog(null,oper.imprimirSumaColumnasFilas());
            JOptionPane.showMessageDialog(null,oper.sumarDiagonalInversa());

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static int obtenerTamanio(){
        int valor=0;
        boolean sentinel = true;
        do{
        try {
            valor= Integer.parseInt(
                    JOptionPane.showInputDialog("Ingresa el valor del tamaño"));
            if (valor > 0){
                sentinel=false;
            }else {
                JOptionPane.showMessageDialog(null,"El valor debe ser mayor que 0");
            }
        }catch (NumberFormatException ex){
            System.out.println("El valor debe ser un numero");
        }
        }while (sentinel);
        return valor;
    }
    public static void llenarMatriz (double [][] matrix) {
        int i = 0, j = 0;
        boolean sentinel = false;
        do {
            do {

                do {
                    try {
                        matrix[i][j]= Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor"));
                        sentinel=false;

                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "El valor debe ser un número");
                    }
                }while (sentinel);
                j++;
            }while (j<matrix[i].length);
            j=0;
            i++;
        }while (i<matrix.length);
    }
    public static void llenarMatriz2 (double [][] matrix2) {
        int i = 0, j = 0;
        boolean sentinel = false;
        do {
            do {

                do {
                    try {
                        matrix2[i][j]= Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor"));
                        sentinel=false;

                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "El valor debe ser un número");
                    }
                }while (sentinel);
                j++;
            }while (j<matrix2[i].length);
            j=0;
            i++;
        }while (i<matrix2.length);
    }
    public static void llenarVector(double [] vector) {

    }
}
