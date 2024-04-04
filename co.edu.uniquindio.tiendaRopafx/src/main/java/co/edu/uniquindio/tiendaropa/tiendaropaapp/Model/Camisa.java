package co.edu.uniquindio.tiendaropa.tiendaropaapp.Model;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;

public class Camisa extends Producto{

    private TipoCuelloCamisa tipoCuelloCamisa;
    private final double DESCUENTO_ITALIANO = 0.05;
    private final double DESCUENTO_AMERICANO = 0.07;
    private final double DESCUENTO_INGLES = 0.1;

    /* Constructor */
    public Camisa() {
    }

    /*Getters and setters*/
    public TipoCuelloCamisa getTipoCuelloCamisa() {
        return tipoCuelloCamisa;
    }

    public void setTipoCuelloCamisa(TipoCuelloCamisa tipoCuelloCamisa) {
        this.tipoCuelloCamisa = tipoCuelloCamisa;
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = 0.0;
        if (tipoCuelloCamisa == TipoCuelloCamisa.ITALIANO) {
            precioDescuento = precioBase - (precioBase * DESCUENTO_ITALIANO);
        }
        if (tipoCuelloCamisa == TipoCuelloCamisa.AMERICANO) {
            precioDescuento = precioBase - (precioBase * DESCUENTO_AMERICANO);
        }
        if (tipoCuelloCamisa == TipoCuelloCamisa.INGLES) {
            precioDescuento = precioBase - (precioBase * DESCUENTO_INGLES);
        }
        return precioDescuento;
    }
}


