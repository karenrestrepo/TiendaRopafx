package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Compra;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Dto.CompraDto;

import java.util.List;

public class TransaccionCompraController {
    ModelFactory modelFactory = new ModelFactory();
    private Compra compra;

    public TransaccionCompraController (){
        modelFactory = ModelFactory.getInstance();
    }


    public List<CompraDto> obtenerCompras() {
        return modelFactory.obtenerCompra();
    }

    public Compra agregarCompra(CompraDto compraDto) {
        return  modelFactory.agregarCompra(compraDto);
    }
}
