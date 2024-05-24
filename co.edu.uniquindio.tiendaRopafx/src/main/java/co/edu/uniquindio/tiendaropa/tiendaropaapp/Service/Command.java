package co.edu.uniquindio.tiendaropa.tiendaropaapp.Service;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;

public interface Command {
    void execute();
    void undo();
    void redo();
}
