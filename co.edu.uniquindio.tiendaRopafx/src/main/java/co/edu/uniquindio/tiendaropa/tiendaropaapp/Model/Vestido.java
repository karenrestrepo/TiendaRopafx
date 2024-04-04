package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Vestido extends Producto {

    private final double DESCUENTO = 0.1;

    /* Constructor */
    public Vestido() {
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = precioBase - (precioBase * DESCUENTO);
        return precioDescuento;

    }
}