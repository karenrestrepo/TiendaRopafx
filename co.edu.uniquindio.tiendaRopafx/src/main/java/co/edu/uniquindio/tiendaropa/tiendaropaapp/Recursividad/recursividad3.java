package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
// Número menor arreglo
//El recorrido del arreglo se realiza de inicio a fin. El criterio de parada
// es cuando inicio y fin son iguales.
//Parámetros: vector[] (es el arreglo en el cual se encuentran los elementos),
// inicio (Es el inicio del arreglo), fin (Es el fin del arreglo y su valor es
// el tamaño del arreglo - 1).
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
