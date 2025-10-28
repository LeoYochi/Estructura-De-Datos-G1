package mx.edu.uttt.matrices;

import javax.swing.*;

public class letras {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        String palabraJ = JOptionPane.showInputDialog("Ingrese la primera palabra de 5 letras");

        char palabraS[] = palabraJ.toCharArray();


        char[][] palabras = {
                {'g', 'A', 't', 'O', 'S'},
                {'P', 'A', 'c', 'A', 'S'},
                {'G', 'a', 'L', 'l', 'o'}
        };

        ChecarPalabra(palabraS,palabras);
    }

    public static void ChecarPalabra(char palabra[], char palabras[][]) {

        int longitud = palabras[0].length;

        if (palabra.length != longitud) {
            JOptionPane.showMessageDialog(null, "Introduce una palabra de " + longitud + " letras");
            return;
        }


        for (int i = 0; i < palabras.length; i++) {

            boolean check = true;

            for (int j = 0; j < longitud; j++) {

                if (palabra[j] != palabras[i][j]) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                JOptionPane.showMessageDialog(null, "¡Tu palabra se encontró con éxito en la fila: " + (i + 1) + "!");
                return;
            }
        }
    }
}