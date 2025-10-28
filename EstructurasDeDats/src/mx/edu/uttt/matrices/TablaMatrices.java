package mx.edu.uttt.matrices;

public class TablaMatrices {
    public static void main(String[] args) {
        int [][] tabla;
        for (int i=1; i<=3;  i++){
            for (int j=1; j<=4; j++){
                int res = i * j;
                System.out.println(i + "*" + j + "=" + (res));
            }
            System.out.println( );
        }
    }
}
