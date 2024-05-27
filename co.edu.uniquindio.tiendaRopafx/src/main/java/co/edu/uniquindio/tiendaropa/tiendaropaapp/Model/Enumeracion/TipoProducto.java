package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion;

public enum TipoProducto {
    PANTALON(100000),
    BLUSA(25000),
    VESTIDO(52000),
    CHAQUETA(75000),
    CAMISA(65000),
    ANILLO(90000),
    MANILLA(35000),
    COLLAR(45000),
    ARETES(29000),
    SANDALIA(60000),
    TENIS(160000),
    BOTA(210000),
    TACON(130000);

    private final double precio;

    TipoProducto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
