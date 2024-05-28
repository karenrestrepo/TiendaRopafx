package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.CalzadoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.ClienteBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona{
    private String prendasCompradas;
    private String fechaUltimaCompra;
    private String metodoPago;
    private String correo;
    private List<Compra> comprasAsociadas = new ArrayList<>();

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    Tienda ownedByTienda;

    /* Constructor */

    public Cliente(){

    }

    public Cliente(String nombreCompleto, String cedula, String sexo, String telefono, String prendasCompradas, String fechaUltimaCompra, String metodoPago, String correo) {
        super(nombreCompleto, cedula, sexo, telefono);
        this.prendasCompradas = prendasCompradas;
        this.fechaUltimaCompra = fechaUltimaCompra;
        this.metodoPago = metodoPago;
        this.correo = correo;
    }


    /* Getters and Setters */
    public String getPrendasCompradas() {
        return prendasCompradas;
    }

    public void setPrendasCompradas(String prendasCompradas) {
        this.prendasCompradas = prendasCompradas;
    }

    public String getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(String fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Compra> getComprasAsociadas() {
        return comprasAsociadas;
    }

    public void setComprasAsociadas(List<Compra> comprasAsociadas) {
        this.comprasAsociadas = comprasAsociadas;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "Nombre Completo = " + getNombreCompleto() + '\'' +
                ", Cédula = " + getCedula() + '\'' +
                ", Sexo = " + getSexo() + '\'' +
                ", Prendas Compradas = " + prendasCompradas + '\'' +
                ", Fecha Ultima Compra = " + fechaUltimaCompra +'\''+
                ", Método de pago = " + metodoPago + '\''+
                '}';
    }
}

