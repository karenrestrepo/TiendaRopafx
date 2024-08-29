package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class r {
    public static void ordenarRecursivo(int[] array, int inicio) {
        if (inicio == array.length - 1) {
            return; // Caso base: si estamos en el último elemento, terminamos
        }

        // Buscar el mayor en la parte restante del array recursivamente
        encontrarMayorYReemplazar(array, inicio, inicio + 1);

        // Llamada recursiva con el siguiente índice
        ordenarRecursivo(array, inicio + 1);
    }

    // Método recursivo para encontrar el mayor en la parte no ordenada
    public static void encontrarMayorYReemplazar(int[] array, int maxIndex, int actual) {
        if (actual == array.length) {
            // Si se ha llegado al final, intercambiamos el mayor con el índice inicial
            int temp = array[maxIndex];
            array[maxIndex] = array[actual - 1];
            array[actual - 1] = temp;
            return;
        }

        // Encontramos el índice del mayor elemento
        if (array[actual] > array[maxIndex]) {
            maxIndex = actual;
        }

        // Llamada recursiva para continuar buscando
        encontrarMayorYReemplazar(array, maxIndex, actual + 1);
    }

    // Método recursivo para imprimir el array
    public static void imprimirArray(int[] array, int indice) {
        if (indice < 0) {
            return; // Caso base: si el índice es negativo, terminamos la impresión
        }

        System.out.print(array[indice] + " ");
        imprimirArray(array, indice - 1);
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 9, 6};

        // Llamada para ordenar el array de izquierda a derecha
        ordenarRecursivo(array, 0);

        // Llamada para imprimir el array ordenado
        imprimirArray(array, array.length - 1);
    }
}
