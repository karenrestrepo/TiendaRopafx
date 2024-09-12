package co.edu.uniquindio.tiendaropa.tiendaropaapp.Recursividad;
//Buscar un elemento en un array de forma recursiva.
public class Recursividad7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int elementoBuscado = 4;
        int i = 0;

        boolean encontrado = buscarElemento(array, i, elementoBuscado);
        if (encontrado){
            System.out.println("El elemento " + elementoBuscado + " ha sido encontrado");
        }else {
            System.out.println("El elemento " + elementoBuscado + "no fue encontrado");
        }
    }

    private static boolean buscarElemento(int[] array, int i, int elementoBuscado) {
        if (i == array.length){
            return false;
        }
        if (array[i] == elementoBuscado){
            return true;

        }
        return buscarElemento(array, i + 1,elementoBuscado);
    }
}
