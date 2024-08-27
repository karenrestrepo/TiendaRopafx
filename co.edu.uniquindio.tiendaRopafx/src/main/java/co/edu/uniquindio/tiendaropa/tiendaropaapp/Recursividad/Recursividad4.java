package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;


public class Recursividad4 {
    public static void main(String[] args) {
        int n = 146756;
        int resultado = sumarCifras(n);
        System.out.println("La suma de las cifras de " + n + " es: " + resultado);
    }

    private static int sumarCifras(int n) {
        if(n < 10){
            return n;

        } else{
            return (n % 10) + sumarCifras(n / 10);
        }
    }
}
