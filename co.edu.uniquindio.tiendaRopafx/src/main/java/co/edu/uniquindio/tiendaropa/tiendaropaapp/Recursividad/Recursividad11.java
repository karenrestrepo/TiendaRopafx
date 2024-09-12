package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Programar un algoritmo recursivo que permita sumar los elementos de
// una matriz. El recorrido tiene que ser retrocediendo en columnas y
// avanzando en las filas. Parámetros( matriz, i, j).
public class Recursividad11 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int suma = sumarElementos(matriz, 0, matriz[0].length - 1);
        System.out.println("Suma de los elementos: " + suma);
    }

    public static int sumarElementos(int[][] matriz, int i, int j) {
        // Caso base: cuando hemos recorrido todas las filas y columnas
        if (i >= matriz.length || j < -1) {
            return 0;
        }
        // Si hemos retrocedido en las columnas hasta el principio, pasamos a la fila anterior
        if (j == -1) {
            return sumarElementos(matriz, i + 1, matriz[0].length - 1);
        }
        // Sumar el elemento actual y continuar recorriendo retrocediendo en las columnas
        return matriz[i][j] + sumarElementos(matriz, i, j - 1);
    }
}
