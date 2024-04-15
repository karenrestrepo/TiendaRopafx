package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.CalzadoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.EmpleadoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Empleado extends Persona {
    private String correo;
    private double salario;
    private TipoContrato tipoContrato;
    private int horasTrabajo;
    Tienda ownedByTienda;

    public static EmpleadoBuilder builder() {
        return new EmpleadoBuilder();
    }

    /* Constructor */

    public Empleado(String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo) {
        super(nombreCompleto, cedula, sexo, telefono);
        this.correo = correo;
        this.salario = salario;
        this.tipoContrato = tipoContrato;
        this.horasTrabajo = horasTrabajo;
    }

    public Empleado() {
    }

    /* Getters and Setters */
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre Completo = " + getNombreCompleto() + '\'' +
                ", Cédula = " + getCedula() + '\'' +
                ", Sexo = " + getSexo() + '\'' +
                ", Telefono = " + getTelefono() + '\'' +
                ", Correo = " + correo +'\''+
                ", Salario = " + salario +'\''+
                ", Tipo contrato = " + tipoContrato +'\''+
                ", Horas de Trabajo = " + horasTrabajo +'\''+
                '}';
    }
}
