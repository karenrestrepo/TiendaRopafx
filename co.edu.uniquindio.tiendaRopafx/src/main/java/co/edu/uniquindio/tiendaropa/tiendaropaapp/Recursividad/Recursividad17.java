package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Retornar el número de la fila de la matriz cuya suma de todos sus elementos sea mayor.
public class Recursividad17 {

    // Método recursivo para sumar los elementos de una fila
    public static int sumarFila(int[][] matriz, int fila, int col) {
        // Caso base: si llegamos al final de la fila
        if (col == matriz[0].length) {
            return 0;
        }
        // Sumar el elemento actual y avanzar en la columna
        return matriz[fila][col] + sumarFila(matriz, fila, col + 1);
    }

    // Método recursivo para encontrar la fila con la mayor suma
    public static int filaMayorSuma(int[][] matriz, int filaActual, int filaMayor, int mayorSuma) {
        // Caso base: si hemos recorrido todas las filas
        if (filaActual == matriz.length) {
            return filaMayor;
        }
        // Sumar los elementos de la fila actual
        int sumaActual = sumarFila(matriz, filaActual, 0);
        // Comparar con la mayor suma encontrada hasta el momento
        if (sumaActual > mayorSuma) {
            return filaMayorSuma(matriz, filaActual + 1, filaActual, sumaActual);
        }
        // Continuar con la siguiente fila
        return filaMayorSuma(matriz, filaActual + 1, filaMayor, mayorSuma);
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int filaConMayorSuma = filaMayorSuma(matriz, 0, 0, Integer.MIN_VALUE);
        System.out.println("La fila con mayor suma es: " + filaConMayorSuma);
    }
}

