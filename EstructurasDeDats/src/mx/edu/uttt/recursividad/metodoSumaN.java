package mx.edu.uttt.recursividad;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;

public class metodoSumaN {
    public static void main(String[] args) {
        try {
            int n= Integer.parseInt(JOptionPane.showInputDialog("Introduce el n"));
            JOptionPane.showMessageDialog(null, "El factorial de: "+n+" es: "+ factorial(n));
//        System.out.println(factorial(n));
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    public  static long factorial(int n) throws IllegalArgumentException{
        if (n<0){
            throw new
            IllegalArgumentException("El valor no puede ser negativo");
        }
        if(n==1){
            return 1;
        }
        if (n==0){
            return 0;
        }
            return n * factorial(n-1);

    }
}
