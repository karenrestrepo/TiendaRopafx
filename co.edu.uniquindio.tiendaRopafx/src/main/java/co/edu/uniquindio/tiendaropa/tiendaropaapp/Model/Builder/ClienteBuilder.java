package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Calzado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Cliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.MetodoPago;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Sexo;

import java.util.Date;

public class ClienteBuilder {
    protected String nombreCompleto;
    protected String cedula;
    protected String sexo;
    protected String telefono;
    protected String productosComprados;
    protected String fechaUltimaCompra;
    protected String metodoPago;

    public ClienteBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public ClienteBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteBuilder sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public ClienteBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteBuilder productosComprado(String productosComprados) {
        this.productosComprados = productosComprados;
        return this;
    }

    public ClienteBuilder fechaUltimaCompra(String fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
        return this;
    }

    public ClienteBuilder metodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public Cliente build(){
        return new Cliente(nombreCompleto, cedula, sexo, telefono, productosComprados, fechaUltimaCompra, metodoPago);
    }
}
