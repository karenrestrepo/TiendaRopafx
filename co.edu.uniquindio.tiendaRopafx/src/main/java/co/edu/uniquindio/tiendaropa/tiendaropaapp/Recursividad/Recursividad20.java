package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad20 {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 9, 6};
        int fin = array.length - 1;
        ordenarDescendente(array,fin);
        imprimirArray(array, fin);
    }

    public static void ordenarDescendente(int[] array, int fin) {
        if (fin == 0) {
            return;
        }

        int maxI = encontrarMaximo(array, 0, fin);

        int numero = array[maxI];
        array[maxI] = array[fin];
        array[fin] = numero;

        ordenarDescendente(array, fin - 1);
    }

    public static int encontrarMaximo(int[] array, int inicio, int fin) {
        if (inicio == fin) {
            return inicio;
        }

        int maxIndexRest = encontrarMaximo(array, inicio + 1, fin);

        return (array[inicio] > array[maxIndexRest]) ? inicio : maxIndexRest;
    }


    public static void imprimirArray(int[] array, int i) {
        if (i < 0) {
            return;
        }

        System.out.print(array[i] + " ");

        imprimirArray(array, i - 1);
    }
}
