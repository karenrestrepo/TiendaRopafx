package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Cliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Sexo;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoContrato;

public class EmpleadoBuilder {
    protected String nombreCompleto;
    protected String cedula;
    protected String sexo;
    protected String telefono;
    protected String correo;
    protected String salario;
    protected String tipoContrato;
    protected String horasTrabajo;

    public EmpleadoBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public EmpleadoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public EmpleadoBuilder sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public EmpleadoBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public EmpleadoBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public EmpleadoBuilder salario(String salario) {
        this.salario = salario;
        return this;
    }

    public EmpleadoBuilder tipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
        return this;
    }

    public EmpleadoBuilder horasTrabajo(String horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
        return this;
    }

    public Empleado build(){
        return new Empleado(nombreCompleto, cedula, sexo, telefono, correo, salario, tipoContrato, horasTrabajo);
    }
}

