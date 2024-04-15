package co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

import java.util.Date;
import java.util.List;

public class  ModelFactory {
    public static ModelFactory modelFactory;

    private Tienda tienda;



    /*Constructor*/
    public ModelFactory(){
        tienda = new Tienda();
        inicializarDatos();

    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {

        Prenda prenda1 = Prenda.builder()
                .nombre("Crop top")
                .referencia("crop123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.S)
                .color(Color.ROSADA)
                .precio(25000)
                .cantidadDisponible(12)
                .tipoPrenda(TipoPrenda.BLUSA)
                .build();

        Prenda prenda2 = Prenda.builder()
                .nombre("Camisa polo")
                .referencia("polo123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.L)
                .color(Color.AZUL)
                .precio(50000)
                .cantidadDisponible(9)
                .tipoPrenda(TipoPrenda.CAMISA)
                .build();

        Prenda prenda3 = Prenda.builder()
                .nombre("Chaqueta cuero")
                .referencia("cuero123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.M)
                .color(Color.NEGRA)
                .precio(75000)
                .cantidadDisponible(20)
                .tipoPrenda(TipoPrenda.CHAQUETA)
                .build();

        Joyeria joyeria1 = Joyeria.builder()
                .nombre("Anillo compromiso")
                .referencia("compromiso123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.S)
                .color(Color.DORADO)
                .precio(750000)
                .cantidadDisponible(2)
                .tipoJoyeria(TipoJoyeria.ANILLO)
                .build();

        Joyeria joyeria2 = Joyeria.builder()
                .nombre("Collar sencilla")
                .referencia("sencilla123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.L)
                .color(Color.PLATEADO)
                .precio(50000)
                .cantidadDisponible(10)
                .tipoJoyeria(TipoJoyeria.COLLAR)
                .build();

        Calzado calzado1 = Calzado.builder()
                .nombre("Bota de cuero")
                .referencia("cuero123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.S)
                .color(Color.LILA)
                .precio(100000)
                .cantidadDisponible(13)
                .tipoCalzado(TipoCalzado.BOTA)
                .build();

        Calzado calzado2 = Calzado.builder()
                .nombre("Tenis deportivos")
                .referencia("deportivo123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.XL)
                .color(Color.AZUL)
                .precio(160000)
                .cantidadDisponible(8)
                .tipoCalzado(TipoCalzado.TENIS)
                .build();

        Cliente cliente1 = Cliente.builder()
                .nombreCompleto("Katherine Mora")
                .cedula("49950")
                .sexo("Femenino")
                .telefono("737559")
                .productosComprado("5")
                .fechaUltimaCompra("16/05/2023")
                .metodoPago("Efectivo")
                .build();

        Cliente cliente2 = Cliente.builder()
                .nombreCompleto("Esteban Cruz")
                .cedula("41150")
                .sexo("Masculino")
                .telefono("739539")
                .productosComprado("15")
                .fechaUltimaCompra("12/04/2024")
                .metodoPago("Tarjeta")
                .build();

        Empleado empleado1 = Empleado.builder()
                .nombreCompleto("Ana Marin")
                .cedula("41240")
                .sexo("Femenino")
                .telefono("737364")
                .correo("ana@gmail.com")
                .salario("1300000")
                .tipoContrato("Horas")
                .horasTrabajo("6")
                .build();

        Empleado empleado2 = Empleado.builder()
                .nombreCompleto("Julio Perez")
                .cedula("10685")
                .sexo("Masculino")
                .telefono("737994")
                .correo("julio@gmail.com")
                .salario("1500000")
                .tipoContrato("Tiempo completo")
                .horasTrabajo("8")
                .build();

        tienda.getListaClientes().add(cliente1);
        tienda.getListaClientes().add(cliente2);
        tienda.getListaEmpleados().add(empleado1);
        tienda.getListaEmpleados().add(empleado2);

    }

    public List<Cliente> obtenerClientes() {
        return tienda.getListaClientes();
    }

    public List<Empleado> obtenerEmpleados() {
        return tienda.getListaEmpleados();
    }

    public boolean agregarCliente(Cliente cliente) {
        return tienda.agregarCliente(cliente);


    }

    public boolean agregarEmpleado(Empleado empleado) {
        return tienda.agregarEmpleado(empleado);
    }
}
