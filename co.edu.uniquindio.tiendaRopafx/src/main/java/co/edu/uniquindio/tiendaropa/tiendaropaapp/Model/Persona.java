package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public abstract class Persona {
    private String nombreCompleto;
    private String cedula;
    private String sexo;
    private String telefono;
    private Cliente cliente;
    private Empleado empleado;
    Tienda ownedByTienda;

    /* Constructor */

    public Persona(String nombreCompleto, String cedula, String sexo, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public Persona() {
    }

    /* Getters and Setters */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Persona {" +
                "Nombre Completo =" + nombreCompleto + '\'' +
                ", Cédula =" + cedula + '\'' +
                ", Sexo =" + sexo + '\'' +
                ", teléfono =" + telefono + '\'' +
                '}';
    }
}
