package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Dto;

public record CompraDto (
        String codigoCompra,
        String fechaCompra,
        String nombreCliente,
        String cedulaCliente,
        String nombreEmpleado,
        String cedulaEmpleado,
        String producto,
        String tipoProducto,
        String talla,
        String color,
        String cantidadProductos

){
}
