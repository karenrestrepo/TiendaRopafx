package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Command;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.EmpleadoController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Memento.EmpleadoMemento;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Service.Command;

public class EliminarEmpleadoCommand implements Command {
    private Empleado empleadoAEliminar;
    private String cedula;
    private EmpleadoController empleadoController;
    private EmpleadoMemento memento;


    public EliminarEmpleadoCommand(EmpleadoController empleadoController,Empleado empleado, String cedula) {
        this.empleadoAEliminar = empleado;
        this.empleadoController = empleadoController;
        this.memento = new EmpleadoMemento(empleado);
        this.cedula = cedula;
    }

    @Override
    public void execute() {
        empleadoController.deleteEmpleado(cedula);
    }

    @Override
    public void undo() {
        if (empleadoController != null && cedula != null) {
            Empleado empleadoRecuperado = new Empleado(memento.getNombreCompleto(), memento.getCedula(), memento.getSexo(), memento.getTelefono(), memento.getCorreo(), memento.getSalario(), memento.getTipoContrato(), memento.getHorasTrabajo());
            empleadoController.agregarEmpleadoExistente(empleadoRecuperado);
        } else {
            System.out.println("Cannot undo, either EmpleadoController or empleadoId is null.");
        }
    }

    @Override
    public void redo() {
        execute();
    }
}
