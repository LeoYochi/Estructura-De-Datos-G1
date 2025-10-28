package mx.edu.uttt.arreglo;
import mx.edu.uttt.poo.Alumno;

public class DeclaracionVectores {
    public static void main(String[] args) {
//Declaración de vectores
        int v1[];
        double v2[], v3[];
        boolean v4[];
        char [] v5;
        String v6[];
//        Alumno v7[];
        //Crear el Vector en memoria
        v1 = new int[4];
        v2 = new double[3];
        v3 = new double[3];
        v4 = new boolean[4];
        v5 = new char[5];
        v6 = new String[4];
        Alumno [] v7 = new Alumno[3];


        int tamanio = v1.length;
        System.out.println(tamanio);

//imprimir valor de un arreglo
    try{
        System.out.println(v3[2]);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("El arreglo se desbordo");
    }

for (int i = 0; i < v6.length; i++) {
        System.out.print("| " + v6[i] + " | ");
    }

System.out.println();

    int i = 0;
do{
        System.out.print("| " + v6[i] + " | ");
        i++;
    }while(i<v6.length);

System.out.println();

    i=0;
while(i<v6.length){
        System.out.print("| " + v6[i] + " | ");
        i++;
    }

for(String valor: v6){
        System.out.print("| " + valor + " | ");

}



}
// public static void imprimir(int [] vector){
//     for (int i = 0; i < vector.length; i++) {
//         System.out.print("| " + vector[i] + " | ");
//     }
//
//     System.out.println();
//
//     int i = 0;
//     do{
//         System.out.print("| " + vector[i] + " | ");
//         i++;
//     }while(i<vector.length);
//
//     System.out.println();
//
//     i=0;
//     while(i<vector.length){
//         System.out.print("| " + vector[i] + " | ");
//         i++;
//     }
//
//     for(String valor: vector){
//         System.out.print("| " + valor + " | ");
//     }
//
//
//
// }
}