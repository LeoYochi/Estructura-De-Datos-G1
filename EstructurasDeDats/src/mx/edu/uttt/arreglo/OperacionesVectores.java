package mx.edu.uttt.arreglo;

import javax.swing.*;

public class OperacionesVectores {
    private double[] vector;
    private final int TAMANO = 5;

    public OperacionesVectores() {

        vector = new double[TAMANO];

    }

    public OperacionesVectores(double[] vector) {
        this.vector = new double[vector.length];
        llenarVector(vector);
    }

    public void llenarVector(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
    }

    public void llenarVector(){
        int i=0;
        do {
            this.vector[i] = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el valor de la posicion [ " + (i+1) + "]"));
            i++;

        }while (i<this.vector.length);
    }

    public void imptimit() {
        this.toString();
    }

    public double sumarElementos(){
        double suma=0;
        for (int i=0; i< vector.length; i++){
            suma += vector[i];
        }
        return suma;
    }
    public double obtenerMaximoValor(){
        int i=0;
        double max = 0.0;
        while(i<this.vector.length){
            if (max<this.vector[i]){
                max = vector[i];
            }
            i++;
        }
       return max;
    }

    public double obtenerMinimoValor(){
        double mini = 0;
        for (int i=0; i< vector.length; i++){
            if (vector.length != 0){
                if (vector[i]< mini){
                    mini = vector[i];
                }
            } else if (vector.length == 0) {
                mini = vector[i];
            }
        }
        return mini;

    }
    public void cambiarTamanioArreglo(int tamanio){
        if (vector.length >= tamanio) {
            double temp[] = new double[tamanio];

            for (int i = 0; i < this.vector.length; i++) {

                temp[i] = vector[i];
            }
            temp = null;
            return;
        }

        System.out.println("No se puede crear un arreglo mas pequeño que el vector");

    }
    public boolean compararArreglos( int tamanio ){

        boolean isEqual = true;
        if (this.vector.length != vector.length) {
            isEqual = false;
            System.out.println();

        }else {
            for (int i=0; i < this.vector.length && isEqual ; i++) {
                if (vector[i] != this.vector[i]){
                    isEqual =false;
                }
            }

        }
        return isEqual;
    }

    public String toString() {
        String salida = "";
        for (double valor : this.vector) {
            salida += "| " + valor + " |";
        }
        return salida;
    }
}
