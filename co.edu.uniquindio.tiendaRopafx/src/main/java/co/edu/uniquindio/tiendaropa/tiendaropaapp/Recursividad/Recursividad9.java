package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Sumar la diagonal de una matriz de forma recursiva.
public class Recursividad9 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int suma = sumarDiagonal(matriz, 0);
        System.out.println("Suma de la diagonal: " + suma);
    }

    public static int sumarDiagonal(int[][] matriz, int i) {
        // Caso base: si el índice está fuera del tamaño de la matriz
        if (i == matriz.length) {
            return 0;
        }
        // Llamada recursiva sumando el elemento en la diagonal y avanzando al siguiente índice
        return matriz[i][i] + sumarDiagonal(matriz, i + 1);
    }
}
