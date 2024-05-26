package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public abstract class Producto /*implements IProducto */{
    private String nombre;
    private String referencia;
    private TipoCliente tipoCliente;
    private TipoProducto tipoProducto;
    private Talla talla;
    private Color color;
    private double precio;
    private int cantidadDisponible;
    private co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto;
    Tienda ownedByTienda;
    private final double IMPUESTO = 0.19;
    private final double IMPUESTO_ADICIONAL = 0.03;

    /* Constructor */
    public Producto() {
    }

    public Producto(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto,
                    Talla talla, Color color, double precio, int cantidadDisponible, co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.tipoCliente = tipoCliente;
        this.tipoProducto = tipoProducto;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.producto = producto;
    }

    /* Getters and Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    public co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto getProducto() {
        return producto;
    }

    public void setProducto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto producto) {
        this.producto = producto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre = " + nombre + '\'' +
                ", Referencia = " + referencia + '\'' +
                ", Tipo Cliente = " + tipoCliente + '\'' +
                ", Talla = " + talla + '\'' +
                ", Color = " + color + '\'' +
                ", Precio = " + precio + '\'' +
                ", Cantidad Disponible = " + cantidadDisponible + '\'' +
                '}';
    }


    public double calcularPrecioBase() {
        double precioBase = getPrecio();
        double precioFinal = 0.0;
        if (getTipoProducto() == TipoProducto.ANILLO) {
            precioFinal = precioBase + (precioBase * (IMPUESTO + IMPUESTO_ADICIONAL));
        }
        if (getTipoProducto() == TipoProducto.PANTALON){
            precioFinal = precioBase + (precioBase * IMPUESTO);
        }
        return precioFinal;
    }


    public double calcularPrecio() {
        double precio = calcularPrecioBase();
        return precio;
    }
}


