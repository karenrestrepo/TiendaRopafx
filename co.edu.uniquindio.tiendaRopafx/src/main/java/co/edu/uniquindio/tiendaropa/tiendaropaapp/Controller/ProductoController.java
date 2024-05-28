package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Producto;

import java.util.List;

public class ProductoController {
    ModelFactory modelFactory = new ModelFactory();

    public ProductoController () {
        modelFactory = ModelFactory.getInstance();
    }


    public List<Producto> obtenerProducto() {
        return modelFactory.obtenerProducto();
    }

    public boolean agregarProducto(Producto producto) {
        return modelFactory.agregarProducto(producto);
    }

    public boolean actualizarProducto(Producto productoActualizado) {
        return modelFactory.actualizarProducto(productoActualizado);
    }

    public boolean deleteProducto(String referenciaProductoEliminado) {
        return modelFactory.deleteProducto(referenciaProductoEliminado);
    }
}
