package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.JoyeriaBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Joyeria extends Producto {
    private TipoJoyeria tipoJoyeria;

    public static JoyeriaBuilder builder() {
        return new JoyeriaBuilder();
    }

    /*Constructor*/

    public Joyeria(TipoJoyeria tipoJoyeria) {
        this.tipoJoyeria = tipoJoyeria;
    }

    public Joyeria(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, TipoJoyeria tipoJoyeria) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible);
        this.tipoJoyeria = tipoJoyeria;
    }
}
