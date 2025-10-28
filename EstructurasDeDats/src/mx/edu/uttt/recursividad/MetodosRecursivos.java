package mx.edu.uttt.recursividad;

import javax.swing.*;

public class MetodosRecursivos {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("introduce n"));
            JOptionPane.showMessageDialog(null, "El factorial de: " + n + " es " + fact(n));

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static long fact(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException("El valor no puedes ser negativo");
        //Caso Base
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        //Csso general
        return n * fact(n - 1);
    }

//    public static int sumarNuymeros(int n) {
//
//    }

}
