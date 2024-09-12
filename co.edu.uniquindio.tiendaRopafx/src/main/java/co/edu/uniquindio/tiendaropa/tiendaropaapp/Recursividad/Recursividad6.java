package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Recorrer un array de forma recursiva
public class Recursividad6 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int i = 0;
        recorrerArray(array, i);

    }

    private static void recorrerArray(int[] array, int i) {
        if(i == array.length){
            return;
        }
        System.out.println("Elemento en el índice " + i + ": " + array[i]);
        recorrerArray(array, i + 1);
    }
}
