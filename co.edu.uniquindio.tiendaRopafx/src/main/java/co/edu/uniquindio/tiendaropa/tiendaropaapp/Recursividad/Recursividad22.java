package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;

public class Recursividad22 {
    public static void main(String[] args) {
        String cadena = "Datos";
        int i = 0;
        
        String resultado = obtenerConsonantes(cadena, i);
        System.out.println("Consonantes: " + resultado);
    }

    private static String obtenerConsonantes(String cadena, int i) {
        if (i == cadena.length()) {
            return ""; 
        }
        
        char actual = cadena.charAt(i);
        
        if (esConsonante(actual)) {
            return actual + obtenerConsonantes(cadena, i + 1);
        } else {
            return obtenerConsonantes(cadena, i + 1); 
        }
    }

    private static boolean esConsonante(char letra) {
        letra = Character.toLowerCase(letra);

        return !(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
    }

}
