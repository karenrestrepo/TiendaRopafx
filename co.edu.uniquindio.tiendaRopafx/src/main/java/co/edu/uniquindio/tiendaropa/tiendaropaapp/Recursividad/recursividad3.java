package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class recursividad3 {
    public static void main(String[] args) {
        int[] vector = {12, 4, 7, 9, 1, 5, 3};
        int inicio = 0;
        int fin = vector.length - 1; // El último índice del arreglo
        int menor = encontrarNumeroMenor(vector, inicio, fin);
        System.out.println("El número menor en el arreglo es: " + menor);
    }

    public static int encontrarNumeroMenor(int[] vector, int inicio, int fin) {
        if (inicio == fin) {
            return vector[inicio];
        } else {
            int menorRestante = encontrarNumeroMenor(vector, inicio + 1, fin);
            return Math.min(vector[inicio], menorRestante);
        }
    }
}
