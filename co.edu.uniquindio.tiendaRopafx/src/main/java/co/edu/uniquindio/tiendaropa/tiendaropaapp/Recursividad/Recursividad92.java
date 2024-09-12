package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad92 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int suma = sumarDiagonalSecundaria(matriz, 0);
        System.out.println("Suma de la diagonal secundaria: " + suma);
    }

    public static int sumarDiagonalSecundaria(int[][] matriz, int i) {
        int n = matriz.length;  // tamaño de la matriz
        // Caso base: si el índice está fuera del tamaño de la matriz
        if (i == n) {
            return 0;
        }
        // Llamada recursiva sumando el elemento en la diagonal secundaria
        return matriz[i][n - 1 - i] + sumarDiagonalSecundaria(matriz, i + 1);
    }
}
