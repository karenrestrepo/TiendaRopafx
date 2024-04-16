package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tienda /*implements ITienda*/ {
    private  String nombre;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Compra> listaCompras = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();
    List<DetalleCompra> listaDetalleCompra = new ArrayList<>();

    /*Constructor*/
    public Tienda() {
    }

    /*Getters and Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "Nombre = " + nombre + '\'' +
                '}';
    }

    public boolean agregarCliente(Cliente nuevoCliente) {
        Cliente clienteEncontrado = obtenerCliente(nuevoCliente.getCedula());
        if (clienteEncontrado == null) {
            getListaClientes().add(nuevoCliente);
            return true;
        }else {
            return false;
        }

    }

    private Cliente obtenerCliente(String cedula) {
        Cliente cliente = null;

        for (Cliente cliente1 : getListaClientes()) {
            if (cliente1.getCedula().equalsIgnoreCase(cedula)) {
                cliente = cliente1;
                break;
            }
        }
        return cliente;
    }

    public boolean agregarEmpleado(Empleado nuevoEmpleado) {
        Empleado empleadoEncontrado = obtenerEmpleado(nuevoEmpleado.getCedula());
        if (empleadoEncontrado == null) {
            getListaEmpleados().add(nuevoEmpleado);
            return true;
        }else {
            return false;
        }
    }

    private Empleado obtenerEmpleado(String cedula) {
        Empleado empleado = null;

        for (Empleado empleado1 : getListaEmpleados()) {
            if (empleado1.getCedula().equalsIgnoreCase(cedula)) {
                empleado = empleado1;
                break;
            }
        }
        return empleado;

    }


    public boolean deleteEmpleado(String cedula) {
        Empleado empleadoEncontrado = obtenerEmpleado(cedula);
        if (empleadoEncontrado == null) {
            Empleado empleado = empleadoEncontrado;
            getListaEmpleados().remove(empleado);
            return true;
        } else {
            return false;
        }

    }

    public boolean actualizarEmpleado(Empleado empleadoActualizado) {
        Empleado empleadoExistente = obtenerEmpleado(empleadoActualizado.getCedula());
        if (empleadoExistente != null) {
            int index = getListaEmpleados().indexOf(empleadoExistente);
            getListaEmpleados().set(index, empleadoActualizado);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarCliente(String cedulaClienteEliminado) {
        Cliente clienteEncontrado= obtenerCliente(cedulaClienteEliminado);
        if (clienteEncontrado == null) {
            Cliente cliente = clienteEncontrado;
            getListaClientes().remove(cliente);
            return true;
        } else {
            return false;
        }
    }
}
