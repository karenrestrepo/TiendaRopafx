package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.PrendaBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Prenda extends Producto{
    public static PrendaBuilder builder() {
        return new PrendaBuilder();
    }


    /*Constructor*/

    public Prenda() {
    }

    public Prenda(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, producto);
    }
}
