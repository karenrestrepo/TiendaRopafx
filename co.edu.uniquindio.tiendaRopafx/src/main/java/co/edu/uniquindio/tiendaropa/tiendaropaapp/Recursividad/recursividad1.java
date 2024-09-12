package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
// Hallar la cantidad de cifras de un número entero. Parámetro: n (número entero)
public class recursividad1 {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Cantidad de cifras: " + contarCifras(n));
    }

    private static int contarCifras(int n) {
        if (n < 10 && n > -10){
            return 1;
        }

        return 1 + contarCifras(n/10);
    }
}
