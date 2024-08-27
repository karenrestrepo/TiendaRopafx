package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad5 {
    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 2, 2, 5, 2};
        int inicio = 0;
        int fin = vector.length - 1;
        int elem = 2;

        int apariciones = contarApariciones(vector, inicio, fin, elem);
        System.out.println("El elemento " + elem + " aparece " + apariciones + " veces en el arreglo.");
    }

    private static int contarApariciones(int[] vector, int inicio, int fin, int elem) {
        if(inicio > fin){
            return 0;
        } else{
            int contar = (vector[inicio] == elem) ? 1 : 0;
            return contar + contarApariciones(vector , inicio + 1, fin, elem);
        }
    }
}
