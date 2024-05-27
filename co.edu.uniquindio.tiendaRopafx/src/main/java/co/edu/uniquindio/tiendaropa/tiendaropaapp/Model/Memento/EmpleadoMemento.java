package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Memento;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder.EmpleadoBuilder;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Persona;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;

public class EmpleadoMemento extends Persona {
    private String correo;
    private String salario;
    private String tipoContrato;
    private String horasTrabajo;
    Tienda ownedByTienda;

    public static EmpleadoBuilder builder() {
        return new EmpleadoBuilder();
    }

    /* Constructor */

    public EmpleadoMemento(Empleado empleado) {
        super(empleado.getNombreCompleto(), empleado.getCedula(), empleado.getSexo(), empleado.getTelefono());
        this.correo = empleado.getCorreo();
        this.salario = empleado.getSalario();
        this.tipoContrato = empleado.getTipoContrato();
        this.horasTrabajo = empleado.getHorasTrabajo();
    }

    public EmpleadoMemento() {
    }

    /* Getters and Setters */
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(String horasTrabajo) {
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
