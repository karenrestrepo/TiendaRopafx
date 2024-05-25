package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Compra;

import java.util.List;

public class TransaccionCompraController {
    ModelFactory modelFactory = new ModelFactory();
    private Compra compra;

    public TransaccionCompraController (){
        modelFactory = ModelFactory.getInstance();
    }


    public List<Compra> obtenerEmpleados() {
        return modelFactory.obtenerCompra();
    }

    public boolean crearCompra(Compra compra) {

    }
}
