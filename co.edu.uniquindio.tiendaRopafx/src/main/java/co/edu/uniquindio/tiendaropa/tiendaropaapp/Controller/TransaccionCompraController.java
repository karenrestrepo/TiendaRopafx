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

    public String calcularPrecio(Compra compra) {
        return modelFactory.calcularPrecio(compra);
    }

    public boolean actualizarCompra(CompraDto compraDtoActualizado) {
        return modelFactory.actualizarCompra(compraDtoActualizado);
    }

    public String calcularPrecioNota(CompraDto compraDtoActualizado) {
        return modelFactory.calcularPrecioNota(compraDtoActualizado);
    }

    public void deleteCompra(String codigoCompraEliminado) {
        modelFactory.deleteCompra(codigoCompraEliminado);
    }
}
