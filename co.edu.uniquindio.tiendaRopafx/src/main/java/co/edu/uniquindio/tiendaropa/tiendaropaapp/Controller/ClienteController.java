package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Cliente;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory = new ModelFactory();

    public ClienteController (){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Cliente> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean agregarCliente(Cliente cliente) {
        return modelFactory.agregarCliente(cliente);
    }

    public boolean deleteCliente(String cedulaClienteEliminado) {
        return modelFactory.deleteCliente(cedulaClienteEliminado);
    }

    public boolean actualizarEmpleado(Cliente clienteActualizado) {
        return modelFactory.actualizarCliente(clienteActualizado);
    }
}
