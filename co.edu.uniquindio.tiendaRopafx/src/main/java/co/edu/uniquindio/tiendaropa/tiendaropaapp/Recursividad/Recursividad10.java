package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Invertir una palabra de forma recursiva
public class Recursividad10 {
    public static void main(String[] args) {
        String palabra = "recursiva";
        String invertida = invertir(palabra);
        System.out.println("Palabra invertida: " + invertida);
    }

    public static String invertir(String palabra) {
        // Caso base: si la palabra tiene 1 o 0 caracteres
        if (palabra.isEmpty()) {
            return palabra;
        }
        // Llamada recursiva: toma el último carácter y llama recursivamente al resto
        return invertir(palabra.substring(1)) + palabra.charAt(0);
    }
}
