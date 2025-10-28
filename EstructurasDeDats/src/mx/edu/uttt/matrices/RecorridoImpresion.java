package mx.edu.uttt.matrices;

import javax.swing.*;

public class RecorridoImpresion {
    public static void main(String[] args) {
        iniciar();

    }
    public static void iniciar (){
        int [][] matri = new int[solicitarNumeroDeFilas()][solicitarNumeroDeColumnas()];
        llenar(matri);
        imprimir(matri);
    }
    public static int solicitarNumeroDeFilas(){
        boolean sentinel = true;
        int numFilas = 0;
        do {
            try {
                numFilas = Integer.parseInt(JOptionPane.showInputDialog("Introducir el numero de filas"));
                if (numFilas>0)
                    sentinel = false;
                else
                    JOptionPane.showMessageDialog(null,"Introduce un numero de filas mayor a 0");
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"El valor debe de ser un entero");
            }


        }while (sentinel);
        return numFilas;
    }
    public static int solicitarNumeroDeColumnas(){
        boolean sentinel = true;
        int numColum = 0;
        do {
            try {
                numColum = Integer.parseInt(JOptionPane.showInputDialog("Introducir el numero de columnas"));
                if (numColum>0)
                    sentinel = false;
                else
                    JOptionPane.showMessageDialog(null,"Introduce un numero de columnas mayor a 0");
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"El valor debe de ser un entero");
            }


        }while (sentinel);
        return numColum;

    }
    public static int solicitarvalor(){
        int valor = 0;
        boolean sentinel = true;
        do {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog("introduce el valor"));
//                if (valor > 0)
                    sentinel = false;
//                else
//                    JOptionPane.showMessageDialog(null,"El valor debe ser mayor a 0");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
            }
        }while (sentinel);
        return valor;
    }
    public static void llenar(int [][] ma){
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[i].length; j++) {
                ma[i][j] = solicitarvalor();
            }

        }

    }
    public static void imprimir(int [][] matrix){
        int i=0;
        int j=0;
        String salida = "";
        while (i<matrix.length){
            j=0;
            while (j< matrix[i].length){
                salida+= matrix[i][j] + " ";
                j++;
            }
            salida+="\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, salida);
    }
}
