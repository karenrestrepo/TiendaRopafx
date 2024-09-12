package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class recursividad30 {

    // Método principal para girar la matriz
    public static String[][] girarRuleta(String[][] matriz, int giros, int sizeFilas, int sizeColumnas) {
        // Caso base: Si ya se completaron todos los giros
        if (giros == 0) {
            return matriz;
        }
        // Crear una nueva matriz para la rotación
        String[][] nuevaMatriz = new String[sizeColumnas][sizeFilas];

        // Girar a la derecha (sentido de las manecillas del reloj)
        if (giros > 0) {
            return girarRuleta(rotarMatriz(matriz, nuevaMatriz, sizeFilas, sizeColumnas, 0, 0), giros - 1, sizeColumnas, sizeFilas);
        }
        // Girar a la izquierda (sentido contrario)
        else {
            return girarRuleta(rotarMatrizInversa(matriz, nuevaMatriz, sizeFilas, sizeColumnas, 0, 0), giros + 1, sizeColumnas, sizeFilas);
        }
    }

    // Método recursivo para rotar la matriz 90 grados a la derecha
    public static String[][] rotarMatriz(String[][] matriz, String[][] nuevaMatriz, int sizeFilas, int sizeColumnas, int i, int j) {
        // Caso base: si se ha recorrido toda la matriz
        if (i == sizeFilas) {
            return nuevaMatriz;
        }
        // Colocar el elemento rotado en la nueva matriz
        nuevaMatriz[j][sizeFilas - 1 - i] = matriz[i][j];

        // Si terminamos con las columnas, pasamos a la siguiente fila
        if (j == sizeColumnas - 1) {
            return rotarMatriz(matriz, nuevaMatriz, sizeFilas, sizeColumnas, i + 1, 0);
        }
        // Continuar con la siguiente columna
        return rotarMatriz(matriz, nuevaMatriz, sizeFilas, sizeColumnas, i, j + 1);
    }

    // Método recursivo para rotar la matriz 90 grados a la izquierda
    public static String[][] rotarMatrizInversa(String[][] matriz, String[][] nuevaMatriz, int sizeFilas, int sizeColumnas, int i, int j) {
        // Caso base: si se ha recorrido toda la matriz
        if (i == sizeFilas) {
            return nuevaMatriz;
        }
        // Colocar el elemento rotado en la nueva matriz en sentido contrario
        nuevaMatriz[sizeColumnas - 1 - j][i] = matriz[i][j];

        // Si terminamos con las columnas, pasamos a la siguiente fila
        if (j == sizeColumnas - 1) {
            return rotarMatrizInversa(matriz, nuevaMatriz, sizeFilas, sizeColumnas, i + 1, 0);
        }
        // Continuar con la siguiente columna
        return rotarMatrizInversa(matriz, nuevaMatriz, sizeFilas, sizeColumnas, i, j + 1);
    }

    // Método recursivo para imprimir la matriz final
    public static void imprimirMatriz(String[][] matriz, int i, int j) {
        if (i == matriz.length) {
            return;
        }
        if (j == matriz[0].length) {
            System.out.println();
            imprimirMatriz(matriz, i + 1, 0);
        } else {
            System.out.print(matriz[i][j] + " ");
            imprimirMatriz(matriz, i, j + 1);
        }
    }

    public static void main(String[] args) {
        String[][] matriz = {
                {"N", "J", "K"},
                {"I", "Z", "Y"},
                {"U", "E", "R"}
        };
        int giros = -1;  // Giros a la derecha (2 giros de 90 grados)

        // Girar la matriz
        String[][] matrizFinal = girarRuleta(matriz, giros, matriz.length, matriz[0].length);

        // Imprimir la matriz final
        System.out.println("Matriz después de " + giros + " giros:");
        imprimirMatriz(matrizFinal, 0, 0);
    }
}

