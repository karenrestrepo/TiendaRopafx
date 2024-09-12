package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Hallar recursivamente el promedio de los elementos de la diagonal de una matriz cuadrada
public class Recursividad15 {
    // Método recursivo para sumar los elementos de la diagonal principal
    public static int sumarDiagonal(int[][] matriz, int i) {
        // Caso base: cuando se alcanza el final de la diagonal
        if (i == matriz.length) {
            return 0;
        }
        // Sumar el elemento en la diagonal principal y avanzar recursivamente
        return matriz[i][i] + sumarDiagonal(matriz, i + 1);
    }

    // Método para calcular el promedio de la diagonal
    public static double promedioDiagonal(int[][] matriz) {
        int suma = sumarDiagonal(matriz, 0);
        return (double) suma / matriz.length;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {2, 1, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double promedio = promedioDiagonal(matriz);
        System.out.println("El promedio de la diagonal es: " + promedio);
    }
}
