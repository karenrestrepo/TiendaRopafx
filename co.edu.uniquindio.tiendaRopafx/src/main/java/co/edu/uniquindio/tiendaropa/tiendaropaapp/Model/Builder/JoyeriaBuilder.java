package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Joyeria;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Prenda;

public class JoyeriaBuilder {
    protected String nombre;
    protected String referencia;
    protected TipoCliente tipoCliente;
    protected TipoProducto tipoProducto;
    protected Talla talla;
    protected Color color;
    protected double precio;
    protected int cantidadDisponible;
    protected Producto producto;

    public JoyeriaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public JoyeriaBuilder referencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public JoyeriaBuilder tipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }

    public JoyeriaBuilder tipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

    public JoyeriaBuilder talla(Talla talla) {
        this.talla = talla;
        return this;
    }

    public JoyeriaBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public JoyeriaBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public JoyeriaBuilder cantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public JoyeriaBuilder producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Joyeria build(){
        return new Joyeria(nombre, referencia, tipoCliente, tipoProducto, talla, color,precio, cantidadDisponible, producto);
    }
}
