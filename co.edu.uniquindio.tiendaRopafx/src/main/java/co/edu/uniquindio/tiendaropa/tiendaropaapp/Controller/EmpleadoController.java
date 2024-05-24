package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Command.EliminarEmpleadoCommand;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Service.Command;

import java.util.List;
import java.util.Stack;

public class EmpleadoController {
    ModelFactory modelFactory = new ModelFactory();
    private Empleado empleado;
    private Stack<Command> executedCommands;
    private Stack<Command> undoneCommands;
    private EliminarEmpleadoCommand eliminarEmpleadoCommand; // Asegúrate de que esta variable se inicialice correctamente


    /**
     * Constructor del controlador de la biblioteca.
     * Inicializa la instancia del modelo de la biblioteca.
     */
    public EmpleadoController (){
        modelFactory = ModelFactory.getInstance();
        this.empleado = empleado;
        this.executedCommands = new Stack<>();
        this.undoneCommands = new Stack<>();
        this.eliminarEmpleadoCommand = eliminarEmpleadoCommand;
    }

    public List<Empleado> obtenerEmpleados() {
        return modelFactory.obtenerEmpleados();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        return modelFactory.agregarEmpleado(empleado);
    }

    public Empleado obtenerEmpleado(String cedula){return modelFactory.obtenerEmpleado(cedula);}

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

    /**
     * Ejecuta un comando y lo agrega a la pila de comandos ejecutados.
     *
     * @param command el comando a ejecutar.
     */
    public void executeCommand(Command command) {
        command.execute();
        executedCommands.push(command);
    }

    /**
     * Deshace el último comando ejecutado y lo agrega a la pila de comandos deshechos.
     * Si no hay comandos ejecutados, este método no hace nada.
     */
    public void undoCommand() {
        if (!executedCommands.isEmpty()) {
            Command lastCommand = executedCommands.pop();
            lastCommand.undo();
            undoneCommands.push(lastCommand);
        }
    }

    /**
     * Rehace el último comando deshecho y lo agrega de nuevo a la pila de comandos ejecutados.
     * Si no hay comandos deshechos, este método no hace nada.
     */
    public void redoCommand() {
        if (!undoneCommands.isEmpty()) {
            Command lastUndoneCommand = undoneCommands.pop();
            lastUndoneCommand.redo();
            executedCommands.push(lastUndoneCommand);
        }
    }

    /**
     * Verifica si la pila de comandos ejecutados está vacía.
     *
     * @return true si la pila de comandos ejecutados está vacía, false en caso contrario.
     */
    public boolean isExecutedCommandsEmpty() {
        return executedCommands.isEmpty();
    }

    /**
     * Verifica si la pila de comandos deshechos está vacía.
     *
     * @return true si la pila de comandos deshechos está vacía, false en caso contrario.
     */
    public boolean isUndoneCommandsEmpty() {
        return undoneCommands.isEmpty();
    }

    public boolean agregarEmpleadoExistente(Empleado empleadoAEliminar) {
        return modelFactory.agregarEmpleadoExistente(empleado);
    }
}
