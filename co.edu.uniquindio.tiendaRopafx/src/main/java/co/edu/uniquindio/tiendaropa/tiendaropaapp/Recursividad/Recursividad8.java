package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Recorrer una matriz de forma recursiva.
public class Recursividad8 {
    public static void main(String[] args) {
        int [][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        recorrerMatriz(matriz,0,0);
    }

    private static void recorrerMatriz(int[][] matriz, int i, int j) {
        if(i == matriz.length){
            return;
        }
        if (j == matriz.length){
            recorrerMatriz(matriz, i + 1, 0);
            return;
        }
        System.out.println("Elemento en [" + i + "][" + j + "]: " + matriz[i][j]);
        recorrerMatriz(matriz, i, j + 1);
    }
}
