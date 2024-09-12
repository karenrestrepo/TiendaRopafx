package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Determinar si una matriz es o no simétrica (es cuadrada y sus elementos
// por encima de la diagonal son iguales a los elementos de por debajo en forma de espejo)
public class Recursividad16 {
    // Método recursivo para verificar si la matriz es simétrica
    public static boolean esSimetrica(int[][] matriz, int fila, int col) {
        // Caso base: si hemos recorrido todas las filas y columnas
        if (fila == matriz.length) {
            return true;
        }
        // Verificar si el elemento por encima de la diagonal es igual al correspondiente por debajo
        if (matriz[fila][col] != matriz[col][fila]) {
            return false;
        }
        // Avanzar en la columna, y si llegamos al final, pasamos a la siguiente fila
        if (col == fila) {
            return esSimetrica(matriz, fila + 1, 0);
        }
        return esSimetrica(matriz, fila, col + 1);
    }

    // Método principal para iniciar la verificación
    public static boolean verificarSimetria(int[][] matriz) {
        return esSimetrica(matriz, 0, 0);
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {2, 5, 6},
                {3, 6, 9}
        };

        if (verificarSimetria(matriz)) {
            System.out.println("La matriz es simétrica.");
        } else {
            System.out.println("La matriz no es simétrica.");
        }
    }
}
