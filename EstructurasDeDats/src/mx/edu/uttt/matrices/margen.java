package mx.edu.uttt.matrices;

import javax.swing.*;

public class margen {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar(){
        int filas = tamanio();
        int columnas = tamanio();
        int [][] matriz = new int[filas][columnas];

        llenarMatriz(matriz);
        mostrarMatriz(matriz);
        laterales(matriz);
        mostrarMatriz(matriz);
    }

    public static void laterales(int m[][]){


        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == 0 || j == 0 || i == m.length-1 || j == m[i].length-1) {
                    m[i][j] = 1;
                }
            }
        }
    }

    public static void mostrarMatriz(int m[][]){
        String mensaje = "";

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                mensaje += m[i][j] + " | ";
            }
            mensaje += "\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    public static void llenarMatriz(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = (int) (Math.round(Math.random() * 10 * 10.0) / 10.0);
            }
        }
    }

    public static int tamanio(){
        int valor = 0;
        boolean sentinel = true;

        do {
            try{
                valor=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño"));
                if(valor > 0){
                    sentinel = false;
                }else{
                    JOptionPane.showMessageDialog(null,
                            "El valor debe ser mayor que cero");
                }
            }catch (NumberFormatException ex) {
                System.out.println("El valor debe ser un número");
            }
        }while(sentinel);

        return valor;
    }
}
