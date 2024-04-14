package co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoCliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoPrenda;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Prenda;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;

public class ModelFactory {
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
        
    }
}
