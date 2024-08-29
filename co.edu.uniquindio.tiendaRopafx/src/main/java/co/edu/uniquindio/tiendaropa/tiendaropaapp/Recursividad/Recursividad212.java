package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad212 {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 9, 6};
        int inicio = 0;

        ordenarArray(array, inicio);
        imprimirArray(array, array.length - 1);

    }
    public static void ordenarArray(int[] array, int inicio) {
        if (inicio == array.length - 1) {
            return;
        }

        int minI = encontrarMinimo(array, inicio, inicio + 1);

        int numero = array[inicio];
        array[inicio] = array[minI];
        array[minI] = numero;

        ordenarArray(array, inicio + 1);
    }

    public static int encontrarMinimo(int[] array, int minI, int actual) {
        if (actual == array.length) {
            return minI;
        }


        if (array[actual] > array[minI]) {
            minI = actual;
        }

        return encontrarMinimo(array, minI, actual + 1);
    }

    public static void imprimirArray(int[] array, int i) {
        if (i < 0) {
            return;
        }

        System.out.print(array[i] + " ");
        imprimirArray(array, i - 1);
    }
}
