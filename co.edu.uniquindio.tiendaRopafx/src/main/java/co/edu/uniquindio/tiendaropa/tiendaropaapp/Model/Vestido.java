package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.VestidoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Vestido extends Producto {

    private final double DESCUENTO = 0.1;

    public static VestidoBuilder builder() {
        return new VestidoBuilder();
    }

    /* Constructor */

    public Vestido() {
    }

    public Vestido(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible);
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = precioBase - (precioBase * DESCUENTO);
        return precioDescuento;

    }
}