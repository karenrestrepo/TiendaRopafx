package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Prenda extends Producto{

    private TipoPrenda tipoPrenda;

    /*Constructor*/

    public Prenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Prenda(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, TipoPrenda tipoPrenda) {
        super(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible);
        this.tipoPrenda = tipoPrenda;
    }
}
