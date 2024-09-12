package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Escribir una función que reciba 2 enteros n y b y devuelva true si n
// es potencia de b. Ej. 16 es potencia de 2, 64 es potencia de 4, 50 no es potencia de 10.
public class Recursividad18 {
    // Método recursivo para verificar si n es potencia de b
    public static boolean esPotencia(int n, int b) {
        // Caso base: si n es 1, es una potencia (b^0 = 1)
        if (n == 1) {
            return true;
        }
        // Si n es menor que b, no es una potencia
        if (n < b || n % b != 0) {
            return false;
        }
        // Continuar dividiendo n entre b
        return esPotencia(n / b, b);
    }

    public static void main(String[] args) {
        int n = 64;
        int b = 4;

        if (esPotencia(n, b)) {
            System.out.println(n + " es potencia de " + b);
        } else {
            System.out.println(n + " no es potencia de " + b);
        }
    }
}
