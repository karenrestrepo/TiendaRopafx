package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;

import java.util.List;

public class EmpleadoController {
    ModelFactory modelFactory = new ModelFactory();

    public EmpleadoController (){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Empleado> obtenerEmpleados() {
        return modelFactory.obtenerEmpleados();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        return modelFactory.agregarEmpleado(empleado);
    }

    public boolean deleteEmpleado(String cedulaEmpleadoEliminado) {
        return modelFactory.deleteEmpleado(cedulaEmpleadoEliminado);
    }

    public boolean actualizarEmpleado(Empleado empleadoActualizado) {
        return modelFactory.actualizarEmpleado(empleadoActualizado);
    }

    public List<Empleado> filtrarEmpleadosPorTipoContrato(String tipoContrato) {
        return modelFactory.filtrarEmpleadosPorTipoContrato(tipoContrato);
    }

    public List<Empleado> filtrarEmpleadosPorSalario(int salarioBase) {
        return modelFactory.filtrarEmpleadosPorSalario(salarioBase);
    }
}
