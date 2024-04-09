package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoCliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoProducto;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Vestido;

public class VestidoBuilder {
    protected String nombre;
    protected String referencia;
    protected TipoCliente tipoCliente;
    protected TipoProducto tipoProducto;
    protected Talla talla;
    protected Color color;
    protected double precio;
    protected int cantidadDisponible;

    public VestidoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VestidoBuilder referencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public VestidoBuilder tipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }

    public VestidoBuilder tipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

    public VestidoBuilder talla(Talla talla) {
        this.talla = talla;
        return this;
    }

    public VestidoBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public VestidoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public VestidoBuilder cantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public Vestido build(){
        return new Vestido(nombre, referencia, tipoCliente, tipoProducto, talla, color,precio, cantidadDisponible);
    }
}
