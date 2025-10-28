package mx.edu.uttt.matrices;

import javax.swing.*;

public class OperacionesMatrices {
    private double[][] m;
    private double[] v;
    private double[] v2;

    public OperacionesMatrices(int numFilas, int numColumnas) {
        if (validarTamanio(numFilas) && validarTamanio(numColumnas)) {
            m = new double[numFilas][numColumnas];
        } else {
            m = new double[2][2];
        }
    }

    private boolean validarTamanio(int tamanio) {
        return tamanio > 0;
    }

    public double[][] getM() {
        return this.m;
    }

    public void setM(double[][] m) {
        if (!(m.length == this.m.length && m[0].length == this.m[0].length))
            return;

        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j] = m[i][j];
            }
        }
    }

    private boolean validarCuadrada() {
        return this.m.length == this.m[m.length - 1].length;
    }

    // ---------- Métodos originales de diagonales ----------
    public double sumarDiagonal() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][i];
        }
        return suma;
    }

    public double sumarDiagonal2() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][i];
        }
        return suma;
    }

    public double sumarDiagonalInversa() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        int j = 0;
        for (int i = m.length - 1; i >= 0; i--) {
            suma += m[i][j];
            j++;
        }
        return suma;
    }

    public double sumarDiagonalInversa2() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][m.length - 1 - i];
        }
        return suma;
    }

    public double sumarDiagonalInversa3() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        int j = 0;
        for (int i = m.length - 1; i >= 0; i--) {
            suma += m[j][i];
            j++;
        }
        return suma;
    }

    public double sumarDiagonalInversa4() throws Exception {
        if (!validarCuadrada())
            throw new Exception("Número no válido");
        double suma = 0.0;
        int j = m.length - 1;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][j];
            j--;
        }
        return suma;
    }

    // ---------- Métodos nuevos (los pediste en ese orden) ----------
    public double[] sumarFilas() {
        double[] sumaFilas = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            double suma = 0;
            for (int j = 0; j < m[i].length; j++) {
                suma += m[i][j];
            }
            sumaFilas[i] = suma;
        }
        return sumaFilas;
    }

    public double[] sumarColumnas() {
        if (m.length == 0) return new double[0];
        double[] sumaColumnas = new double[m[0].length];
        for (int j = 0; j < m[0].length; j++) {
            double suma = 0;
            for (int i = 0; i < m.length; i++) {
                suma += m[i][j];
            }
            sumaColumnas[j] = suma;
        }
        return sumaColumnas;
    }

    public String imprimirSumaColumnasFilas() {
        double[] filas = sumarFilas();
        double[] cols  = sumarColumnas();

        StringBuilder sb = new StringBuilder();
        sb.append("Suma por filas:\n");
        for (int i = 0; i < filas.length; i++) {
            sb.append(" | ").append(filas[i]).append("\t");
        }
        sb.append("\nSuma por columnas:\n");
        for (int j = 0; j < cols.length; j++) {
            sb.append(" | ").append(cols[j]).append("\n");
        }

        // Si quieres también mostrar en JOptionPane:
        // JOptionPane.showMessageDialog(null, sb.toString());
        return sb.toString();
    }

    public void sumarMatrices(double[][] m1, double[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            JOptionPane.showMessageDialog(null, "Las matrices deben tener el mismo tamaño");
            return;
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }
    }

    public void restarMatrices(double[][] m1, double[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            JOptionPane.showMessageDialog(null, "Las matrices deben tener el mismo tamaño");
            return;
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m[i][j] = m1[i][j] - m2[i][j];
            }
        }
    }

    public void multiplicarMatrices(double[][] m1, double[][] m2) {
        if (m1[0].length != m2.length) {
            JOptionPane.showMessageDialog(null, "Número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz");
            return;
        }
        double[][] resultado = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    resultado[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        m = resultado; // actualizar la matriz principal
    }

    public void calcularTranspuesta(double[][] m, double[][] t) {
        double[][] transpuesta = new double[this.m[0].length][this.m.length];
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                transpuesta[j][i] = this.m[i][j];
            }
        }
        this.m = transpuesta;
    }

//vectores

    public void imprimir(){
        String salida ="";
        for (double [] fila: this.m){
            for (double valor: fila){
                salida+= valor + "  |  ";
            }
            salida+="\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }


}

