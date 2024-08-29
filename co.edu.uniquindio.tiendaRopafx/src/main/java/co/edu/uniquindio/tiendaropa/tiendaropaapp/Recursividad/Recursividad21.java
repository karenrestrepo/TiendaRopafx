package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad21 {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 9, 6};
        int fin = array.length - 1;
        ordenarCreciente(array,fin);
        imprimirArray(array, fin);
    }

    public static int encontrarMinimo(int[] array, int inicio, int fin) {
        if (inicio == fin) {
            return inicio;
        }

        int maxIndexRest = encontrarMinimo(array, inicio + 1, fin);

        return (array[inicio] < array[maxIndexRest]) ? inicio : maxIndexRest;
    }


    public static void ordenarCreciente(int[] array, int fin) {
        if (fin == 0) {
            return;
        }

        int minI = encontrarMinimo(array, 0, fin);

        int numero = array[minI];
        array[minI] = array[fin];
        array[fin] = numero;

        ordenarCreciente(array, fin - 1);
    }
    public static void imprimirArray(int[] array, int i) {
        if (i < 0) {
            return;
        }

        System.out.print(array[i] + " ");

        imprimirArray(array, i - 1);
    }
}
