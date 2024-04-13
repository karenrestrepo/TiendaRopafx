package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Builder;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Sexo;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoContrato;

public class EmpleadoBuilder {
    protected String nombreCompleto;
    protected String cedula;
    protected Sexo sexo;
    protected long telefono;
    protected String correo;
    protected double salario;
    protected TipoContrato tipoContrato;
    protected int horasTrabajo;

    public EmpleadoBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public EmpleadoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public EmpleadoBuilder sexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public EmpleadoBuilder telefono(Long telefono) {
        this.telefono = telefono;
        return this;
    }

    public EmpleadoBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public EmpleadoBuilder salario(double salario) {
        this.salario = salario;
        return this;
    }

    public EmpleadoBuilder tipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
        return this;
    }

    public EmpleadoBuilder horasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
        return this;
    }
}

