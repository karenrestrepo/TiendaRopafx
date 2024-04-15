package co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Calzado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Joyeria;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Prenda;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;

public class  ModelFactory {
    private static ModelFactory modelFactory;

    private Tienda tienda;



    /*Constructor*/
    private ModelFactory(){
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
                .nombre("Collar sencilla")
                .referencia("sencilla123")
                .tipoCliente(TipoCliente.MUJER)
                .talla(Talla.L)
                .color(Color.PLATEADO)
                .precio(50000)
                .cantidadDisponible(10)
                .tipoJoyeria(TipoJoyeria.COLLAR) 
                .build();

    }
}
