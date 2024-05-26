package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Calzado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

import java.util.Date;

public class CalzadoBuilder {
    protected String nombre;
    protected String referencia;
    protected TipoCliente tipoCliente;
    protected TipoProducto tipoProducto;
    protected Talla talla;
    protected Color color;
    protected double precio;
    protected int cantidadDisponible;
    protected Producto producto;

    public CalzadoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CalzadoBuilder referencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public CalzadoBuilder tipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }

    public CalzadoBuilder tipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

    public CalzadoBuilder talla(Talla talla) {
        this.talla = talla;
        return this;
    }

    public CalzadoBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public CalzadoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public CalzadoBuilder cantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public CalzadoBuilder producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Calzado build(){
        return new Calzado(nombre, referencia, tipoCliente, tipoProducto, talla, color,precio, cantidadDisponible, producto);
    }
}
