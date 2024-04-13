package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Calzado extends Producto{
    private TipoCalzado tipoCalzado;

    /*Constructor*/

    public Calzado(TipoCalzado tipoCalzado) {
        this.tipoCalzado = tipoCalzado;
    }

    public Calzado(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, TipoCalzado tipoCalzado) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible);
        this.tipoCalzado = tipoCalzado;
    }
}
