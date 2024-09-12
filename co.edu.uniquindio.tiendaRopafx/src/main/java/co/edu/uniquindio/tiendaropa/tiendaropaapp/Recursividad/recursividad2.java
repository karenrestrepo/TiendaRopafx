package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Contar la cantidad de ceros que se encuentran dentro de un arreglo
// unidimensional de enteros. Parámetros: int arreglo[], int n
public class recursividad2 {
    public static void main(String[] args) {
        int[] arreglo = {1, 0, 2, 0, 4, 0, 5}; // Ejemplo de arreglo
        int n = 0;
        int cantidadCeros = contarCeros(arreglo, n);
        System.out.println("La cantidad de ceros en el arreglo es: " + cantidadCeros);
    }
    public static int contarCeros(int[] arreglo, int n) {
        if (n >= arreglo.length) {
            return 0;
        }
        return (arreglo[n] == 0 ? 1 : 0) + contarCeros(arreglo, n + 1);
    }
}
