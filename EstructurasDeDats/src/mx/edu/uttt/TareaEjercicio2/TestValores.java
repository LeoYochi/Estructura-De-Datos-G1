package mx.edu.uttt.TareaEjercicio2;

import javax.swing.JOptionPane;

public class TestValores {
    public static void main(String[] args) {
        int cantidad = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el número de valores a almacenar:")
        );

        GestorValores gestor = new GestorValores(cantidad);

        gestor.llenarValores();

        double promedio = gestor.calcularPromedio();
        int mayores = gestor.contarMayores(promedio);
        String lista = gestor.listaMayores(promedio);

        String mensaje = "-----Promedio: " + promedio + "\n-----" +
                         "-----Número de valores mayores que el promedio: " + mayores + "\n-----" +
                         "-----Valores mayores que el promedio:\n" + lista +"-----";

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
