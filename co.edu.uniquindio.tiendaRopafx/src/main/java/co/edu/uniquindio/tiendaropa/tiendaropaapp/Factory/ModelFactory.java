package co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Dto.CompraDto;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class  ModelFactory {
    public static ModelFactory modelFactory;
    private Tienda tienda;
    private Empleado empleado;

    /*Constructor*/
    public ModelFactory(){
        tienda = new Tienda();
        inicializarDatos();
        iniCompra();


    }

    private void iniCompra() {
        Compra compra = new Compra();
        compra.setCodigoCompra("FE-O1");
        compra.setFechaCompra(new Date(24, 05, 05 ));
        compra.setClienteAsociado(tienda.getListaClientes().get(0));
        compra.setEmpleadoAsociado(tienda.getListaEmpleados().get(0));
        compra.setProductoAsociado(tienda.getListaProductos().get(0));
        compra.setDetalleCompra(tienda.getListaDetalleCompra().get(0));

        Compra compra1 = new Compra();
        compra1.setCodigoCompra("FE-O1");
        compra1.setFechaCompra(new Date(24, 05, 06 ));
        compra1.setClienteAsociado(tienda.getListaClientes().get(1));
        compra1.setEmpleadoAsociado(tienda.getListaEmpleados().get(1));
        compra1.setProductoAsociado(tienda.getListaProductos().get(1));
        compra1.setDetalleCompra(tienda.getListaDetalleCompra().get(0));

        tienda.getListaCompras().add(compra);
        tienda.getListaCompras().add(compra1);

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
                .producto(Producto.PRENDA)
                .tipoProducto(TipoProducto.BLUSA)
                .build();

        Prenda prenda2 = Prenda.builder()
                .nombre("Camisa polo")
                .referencia("polo123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.L)
                .color(Color.AZUL)
                .precio(50000)
                .cantidadDisponible(9)
                .tipoProducto(TipoProducto.CAMISA)
                .producto(Producto.PRENDA)
                .build();

        Prenda prenda3 = Prenda.builder()
                .nombre("Chaqueta cuero")
                .referencia("cuero123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.M)
                .color(Color.NEGRA)
                .precio(75000)
                .cantidadDisponible(20)
                .tipoProducto(TipoProducto.CHAQUETA)
                .producto(Producto.PRENDA)
                .build();

        Joyeria joyeria1 = Joyeria.builder()
                .nombre("Anillo compromiso")
                .referencia("compromiso123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.S)
                .color(Color.DORADO)
                .precio(750000)
                .cantidadDisponible(2)
                .tipoProducto(TipoProducto.ANILLO)
                .producto(Producto.JOYERIA)
                .build();

        Joyeria joyeria2 = Joyeria.builder()
                .nombre("Collar sencilla")
                .referencia("sencilla123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.L)
                .color(Color.PLATEADO)
                .precio(50000)
                .cantidadDisponible(10)
                .tipoProducto(TipoProducto.COLLAR)
                .producto(Producto.JOYERIA)
                .build();

        Calzado calzado1 = Calzado.builder()
                .nombre("Bota de cuero")
                .referencia("cuero123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.S)
                .color(Color.LILA)
                .precio(100000)
                .cantidadDisponible(13)
                .tipoProducto(TipoProducto.BOTA)
                .producto(Producto.CALZADO)
                .build();

        Calzado calzado2 = Calzado.builder()
                .nombre("Tenis deportivos")
                .referencia("deportivo123")
                .tipoCliente(TipoCliente.HOMBRE)
                .talla(Talla.XL)
                .color(Color.AZUL)
                .precio(160000)
                .cantidadDisponible(8)
                .tipoProducto(TipoProducto.TENIS)
                .producto(Producto.CALZADO)
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

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setNumeroDetalle(111);
        detalleCompra.setCantidadComprado(2);
        detalleCompra.setValorTotal(20000);
        detalleCompra.setProductoComprado("prendas, joyerías y calzado");

        DetalleCompra detalleCompra1 = new DetalleCompra();
        detalleCompra1.setNumeroDetalle(112);
        detalleCompra1.setCantidadComprado(3);
        detalleCompra1.setValorTotal(29900);
        detalleCompra1.setProductoComprado("prendas, joyerías y calzado");

        tienda.getListaDetalleCompra().add(detalleCompra);
        tienda.getListaDetalleCompra().add(detalleCompra1);
        tienda.getListaClientes().add(cliente1);
        tienda.getListaClientes().add(cliente2);
        tienda.getListaEmpleados().add(empleado1);
        tienda.getListaEmpleados().add(empleado2);
        tienda.getListaProductos().add(calzado1);
        tienda.getListaProductos().add(calzado2);
        tienda.getListaProductos().add(prenda1);
        tienda.getListaProductos().add(prenda2);
        tienda.getListaProductos().add(prenda3);
        tienda.getListaProductos().add(joyeria1);
        tienda.getListaProductos().add(joyeria2);

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

    public boolean deleteEmpleado(String cedula) {
        return tienda.deleteEmpleado(cedula);
    }

    public boolean actualizarEmpleado(Empleado empleadoActualizado) {
        return tienda.actualizarEmpleado(empleadoActualizado);
    }

    public boolean deleteCliente(String cedulaClienteEliminado) {
        return tienda.eliminarCliente(cedulaClienteEliminado);
    }

    public List<Empleado> filtrarEmpleadosPorSalario(int salarioBase) {
        return tienda.filtrarEmpleadosSalario(salarioBase);
    }

    public List<Empleado> filtrarEmpleadosPorTipoContrato(String tipoContrato) {
        return tienda.filtrarEmpleadosPorTipoContrato(tipoContrato);
    }

    public boolean actualizarCliente(Cliente clienteActualizado) {
        return tienda.actualizarCliente(clienteActualizado);
    }

    public Empleado obtenerEmpleado(String cedula) {
        return tienda.obtenerEmpleado(cedula);
    }

//    public boolean agregarEmpleadoExistente(Empleado empleado) {
//        return tienda.agregarEmpleadoExistente(empleado);
//    }

    public boolean agregarEmpleadoExistente(Empleado empleadoAEliminar) {
        return tienda.agregarEmpleadoExistente(empleadoAEliminar);
    }

    public List<CompraDto> obtenerCompra() {
        List<Compra> compraList = tienda.getListaCompras();
        List<CompraDto> compraDtoList = new ArrayList<>();

        for (Compra compra : compraList){
            compraDtoList.add(buildCompraDto(compra));
        }
        return compraDtoList;
    }

    private CompraDto buildCompraDto(Compra compra) {
        return new CompraDto(
                compra.getCodigoCompra(),
                compra.getFechaCompra().toString(),
                compra.clienteAsociado.getNombreCompleto(),
                compra.clienteAsociado.getCedula(),
                compra.empleadoAsociado.getNombreCompleto(),
                compra.empleadoAsociado.getCedula(),
                compra.productoAsociado.getProducto().toString(),
                compra.productoAsociado.getTipoProducto().toString(),
                compra.productoAsociado.getTalla().toString(),
                compra.productoAsociado.getColor().toString(),
                Integer.toString(compra.detalleCompra.getCantidadComprado())

        );
    }

    public boolean agregarCompra(CompraDto compraDto) {
        Compra compra = buildCompra(compraDto);
        return tienda.agregarCompra(compra);
    }

    private Compra buildCompra(CompraDto compraDto) {
        try {
            Compra compra = new Compra();

            compra.setCodigoCompra(compraDto.codigoCompra());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaCompra = dateFormat.parse(compraDto.fechaCompra());
            compra.setFechaCompra(fechaCompra);

            Cliente cliente = new Cliente();
            cliente.setNombreCompleto(compraDto.nombreCliente());
            cliente.setCedula(compraDto.cedulaCliente());
            compra.setClienteAsociado(cliente);

            Empleado empleado = new Empleado();
            empleado.setNombreCompleto(compraDto.nombreEmpleado());
            empleado.setCedula(compraDto.cedulaEmpleado());
            compra.setEmpleadoAsociado(empleado);

            Calzado calzado = new Calzado();
            Joyeria joyeria = new Joyeria();
            Prenda prenda = new Prenda();
            String producto = compraDto.producto();
            if (producto.equalsIgnoreCase("CALZADO")) {
                calzado = new Calzado();
                calzado.setProducto(Producto.valueOf(compraDto.producto()));
                calzado.setTipoProducto(TipoProducto.valueOf((compraDto.tipoProducto())));
                calzado.setTalla(Talla.valueOf(compraDto.talla()));
                calzado.setColor(Color.valueOf(compraDto.color()));

                compra.setProductoAsociado(calzado);

            } else if (producto.equalsIgnoreCase("JOYERIA")) {
                joyeria = new Joyeria();
                joyeria.setProducto(Producto.valueOf(compraDto.producto()));
                joyeria.setTipoProducto(TipoProducto.valueOf((compraDto.tipoProducto())));
                joyeria.setTalla(Talla.valueOf(compraDto.talla()));
                joyeria.setColor(Color.valueOf(compraDto.color()));

                compra.setProductoAsociado(joyeria);

            } else if (producto.equalsIgnoreCase("PRENDA")) {
                prenda = new Prenda();
                prenda.setProducto(Producto.valueOf(compraDto.producto()));
                prenda.setTipoProducto(TipoProducto.valueOf((compraDto.tipoProducto())));
                prenda.setTalla(Talla.valueOf(compraDto.talla()));
                prenda.setColor(Color.valueOf(compraDto.color()));

                compra.setProductoAsociado(prenda);
            }
            else {
                System.out.println("Tipo de producto no válido: " + producto);
                return null;
            }

            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setCantidadComprado(Integer.parseInt(compraDto.cantidadProductos()));
            compra.setDetalleCompra(detalleCompra);

            return compra;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
