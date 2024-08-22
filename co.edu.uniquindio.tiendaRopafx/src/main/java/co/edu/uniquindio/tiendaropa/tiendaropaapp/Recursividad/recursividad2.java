package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class recursividad2 {
    public static void main(String[] args) {
        int[] arreglo = {1, 0, 2, 0, 4, 0, 5}; // Ejemplo de arreglo
        int cantidadCeros = contarCeros(arreglo, 0);
        System.out.println("La cantidad de ceros en el arreglo es: " + cantidadCeros);
    }
    public static int contarCeros(int[] arreglo, int i) {
        if (i >= arreglo.length) {
            return 0;
        }
        return (arreglo[i] == 0 ? 1 : 0) + contarCeros(arreglo, i + 1);
    }
}
