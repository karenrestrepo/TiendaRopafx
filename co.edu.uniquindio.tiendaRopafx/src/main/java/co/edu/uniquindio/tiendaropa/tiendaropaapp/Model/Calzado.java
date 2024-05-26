package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.CalzadoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Calzado extends Producto{

    public static CalzadoBuilder builder() {
        return new CalzadoBuilder();
    }

    /*Constructor*/

    public Calzado() {
    }

    public Calzado(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, producto);
    }
}
