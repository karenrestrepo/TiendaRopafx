package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Prenda;

public class PrendaBuilder {
    protected String nombre;
    protected String referencia;
    protected TipoCliente tipoCliente;
    protected TipoProducto tipoProducto;
    protected Talla talla;
    protected Color color;
    protected double precio;
    protected int cantidadDisponible;
    protected TipoPrenda tipoPrenda;

    public PrendaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PrendaBuilder referencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public PrendaBuilder tipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }

    public PrendaBuilder tipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

    public PrendaBuilder talla(Talla talla) {
        this.talla = talla;
        return this;
    }

    public PrendaBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public PrendaBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public PrendaBuilder cantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public PrendaBuilder tipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
        return this;
    }

    public Prenda build(){
        return new Prenda(nombre, referencia, tipoCliente, tipoProducto, talla, color,precio, cantidadDisponible, tipoPrenda);
    }
}
