package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.JoyeriaBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Joyeria extends Producto {

    public static JoyeriaBuilder builder() {
        return new JoyeriaBuilder();
    }

    /*Constructor*/

    public Joyeria() {
    }

    public Joyeria(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, producto);
    }
}
