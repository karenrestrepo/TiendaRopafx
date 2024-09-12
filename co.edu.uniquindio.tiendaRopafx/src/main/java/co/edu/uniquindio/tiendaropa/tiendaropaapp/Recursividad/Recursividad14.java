package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Dado un vector de n enteros, el problema a resolver recursivamente
// consiste en contar el número  de veces que un valor dado aparece en dicho vector:
public class Recursividad14 {
    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 2, 2, 5};
        int n = vector.length;
        int objetivo = 2;
        int i = 0;
        int apariciones = contarApariciones(vector, objetivo, n, i);
        System.out.println("El número " + objetivo + " aparece " + apariciones + " veces en el vector.");
    }
    public static int contarApariciones(int[] vector, int objetivo, int n, int i) {
        // Caso base: cuando se ha recorrido todo el vector
        if (i == n) {
            return 0;
        }
        // Si el elemento actual coincide con el objetivo, sumamos 1
        if (vector[i] == objetivo) {
            return 1 + contarApariciones(vector, objetivo, n,  i + 1);
        } else {
            // Si no coincide, simplemente continuamos sin sumar
            return contarApariciones(vector, objetivo, n, i + 1);
        }
    }
}
