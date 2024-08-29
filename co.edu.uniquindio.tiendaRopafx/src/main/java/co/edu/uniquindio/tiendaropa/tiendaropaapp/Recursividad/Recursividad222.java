package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad222 {
    public static void main(String[] args) {
        String cadena = "Datos";
        String resultado = obtenerConsonantes(cadena, cadena.length() - 1);

        System.out.println("Consonantes: " + resultado);
    }

    private static String obtenerConsonantes(String cadena, int i) {
        if (i < 0) {
            return ""; 
        }
        
        char actual = cadena.charAt(i);
        
        if (esConsonante(actual)) {
            return obtenerConsonantes(cadena, i - 1) + actual;
        } else {
            return obtenerConsonantes(cadena, i - 1);
        }
    }

    private static boolean esConsonante(char letra) {
        letra = Character.toLowerCase(letra);

        return !(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
    }

}
