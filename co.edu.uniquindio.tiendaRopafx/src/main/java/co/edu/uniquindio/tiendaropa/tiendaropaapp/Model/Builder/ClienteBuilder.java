package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.MetodoPago;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Sexo;

import java.util.Date;

public class ClienteBuilder {
    protected String nombreCompleto;
    protected String cedula;
    protected Sexo sexo;
    protected long telefono;
    protected int productosComprados;
    protected Date fechaUltimaCompra;
    protected MetodoPago metodoPago;

    public ClienteBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public ClienteBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteBuilder sexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public ClienteBuilder telefono(Long telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteBuilder productosComprado(int productosComprados) {
        this.productosComprados = productosComprados;
        return this;
    }

    public ClienteBuilder fechaUltimaCompra(Date fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
        return this;
    }

    public ClienteBuilder metodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }
}
