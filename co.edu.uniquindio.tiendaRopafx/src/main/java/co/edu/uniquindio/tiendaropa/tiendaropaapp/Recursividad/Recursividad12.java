package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Programar un algoritmo recursivo que permita calcular y retornar
// cualquier potencia para cualquier número. Por ejemplo base = 2 potencia = 3
public class Recursividad12 {
    public static void main(String[] args) {
        int base = 2;
        int exponente = 3;
        int resultado = calcularPotencia(base, exponente);
        System.out.println(base + " elevado a " + exponente + " es: " + resultado);
    }

    public static int calcularPotencia(int base, int exponente) {
        // Caso base: cualquier número elevado a la potencia 0 es 1
        if (exponente == 0) {
            return 1;
        }
        // Caso recursivo: base * base^(exponente - 1)
        return base * calcularPotencia(base, exponente - 1);
    }
}
