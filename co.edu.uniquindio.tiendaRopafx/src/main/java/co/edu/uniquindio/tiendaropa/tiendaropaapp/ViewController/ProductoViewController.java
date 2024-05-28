package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.ClienteController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.ProductoController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.*;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoProducto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductoViewController {
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    Producto productoSeleccionado;
    Tienda tienda;
    ProductoController productoController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TableColumn<Producto, String> tcCantidadProductos;

    @FXML
    private TableColumn<Producto, String> tcColor;

    @FXML
    private TableColumn<Producto, String> tcNombreProducto;

    @FXML
    private TableColumn<Producto, String> tcPrecio;

    @FXML
    private TableColumn<Producto, String> tcReferencia;

    @FXML
    private TableColumn<Producto, String> tcTalla;

    @FXML
    private TableColumn<Producto, String> tcTipoProducto;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtColorProducto;

    @FXML
    private TextField txtFiltrarProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private TextField txtReferenciaProducto;

    @FXML
    private TextField txtTallaProducto;

    @FXML
    private TextField txtTipoProducto;

    @FXML
    void onActualizarProducto(ActionEvent event) {
        if (productoSeleccionado != null) {
            Producto productoActualizado = construirDatosProducto();
            if (productoController.actualizarProducto(productoActualizado)) {
                int index = listaProductos.indexOf(productoSeleccionado);
                listaProductos.set(index, productoActualizado);
                mostrarMensaje("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación cliente", "Error al actualizar", "No se pudo actualizar el cliente", Alert.AlertType.ERROR);
            }
        }

    }

    @FXML
    void onAgregarProducto(ActionEvent event) {
        if (validarFormulario()) {
            Producto producto = construirDatosProducto();
            if (productoController.agregarProducto(producto)) {
                listaProductos.add(producto);
                mostrarMensaje("Notificación producto", "Producto creado", "El producto se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposProducto();

            }else{
                mostrarMensaje("Notificación producto", "Producto no creado", "El producto no se ha creado con éxito", Alert.AlertType.ERROR);

            }
        }else{
            mostrarMensaje("Notificación producto", "Producto no creado", "El producto no se ha creado con éxito", Alert.AlertType.ERROR);

        }


    }

    private boolean validarFormulario() {
        if (txtNombreProducto.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private Producto construirDatosProducto() {
        Producto producto1 = null;
        String producto = txtNombreProducto.getText();
        if (producto.equalsIgnoreCase("CALZADO")) {
            producto1 = Calzado.builder()
                    .producto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto.valueOf(txtNombreProducto.getText()))
                    .referencia(txtReferenciaProducto.getText())
                    .tipoProducto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoProducto.valueOf(txtTipoProducto.getText()))
                    .talla(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla.valueOf(txtTallaProducto.getText()))
                    .color(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color.valueOf(txtColorProducto.getText()))
                    .precio(Double.parseDouble(txtPrecioProducto.getText()))
                    .cantidadDisponible(Integer.parseInt(txtCantidad.getText()))
                    .build();


        } else if (producto.equalsIgnoreCase("JOYERIA")) {
            producto1 = Joyeria.builder()
                    .producto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto.valueOf(txtNombreProducto.getText()))
                    .referencia(txtReferenciaProducto.getText())
                    .tipoProducto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoProducto.valueOf(txtTipoProducto.getText()))
                    .talla(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla.valueOf(txtTallaProducto.getText()))
                    .color(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color.valueOf(txtColorProducto.getText()))
                    .precio(Double.parseDouble(txtPrecioProducto.getText()))
                    .cantidadDisponible(Integer.parseInt(txtCantidad.getText()))
                    .build();

        } else if (producto.equalsIgnoreCase("PRENDA")) {
            producto1 = Prenda.builder()
                    .producto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Producto.valueOf(txtNombreProducto.getText()))
                    .referencia(txtReferenciaProducto.getText())
                    .tipoProducto(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.TipoProducto.valueOf(txtTipoProducto.getText()))
                    .talla(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Talla.valueOf(txtTallaProducto.getText()))
                    .color(co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Enumeracion.Color.valueOf(txtColorProducto.getText()))
                    .precio(Double.parseDouble(txtPrecioProducto.getText()))
                    .cantidadDisponible(Integer.parseInt(txtCantidad.getText()))
                    .build();
        }
        else {
            System.out.println("Tipo de producto no válido: " + producto);
            return null;
        }
        return producto1;
    }

    private void limpiarCamposProducto() {
        txtNombreProducto.setText("");
        txtReferenciaProducto.setText("");
        txtTipoProducto.setText("");
        txtTallaProducto.setText("");
        txtColorProducto.setText("");
        txtPrecioProducto.setText("");
        txtCantidad.setText("");
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @FXML
    void onEliminararProducto(ActionEvent event) {
        String referenciaProductoEliminado = txtReferenciaProducto.getText();
        productoController.deleteProducto(referenciaProductoEliminado);
        listaProductos.removeIf(producto -> producto.getReferencia().equals(referenciaProductoEliminado));
        mostrarMensaje("Notificación producto", "Producto eliminado", "El producto se ha eliminado con éxito", Alert.AlertType.INFORMATION);


    }

    @FXML
    void initialize() {
        productoController = new ProductoController();
        iniView();
    }

    private void iniView() {
        iniDataBinding();
        obtenerProductos();
        tableProducto.getItems().clear();
        tableProducto.setItems(listaProductos);
        listenerSelectionProducto();
        mostrarProducto();
    }

    private void iniDataBinding() {
        tcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProducto().toString()));
        tcReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReferencia()));
        tcTipoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoProducto().toString()));
        tcTalla.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTalla().toString()));
        tcColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor().toString()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        tcCantidadProductos.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCantidadDisponible())));
    }

    private void obtenerProductos() {
        listaProductos.addAll(productoController.obtenerProducto());
    }

    private void listenerSelectionProducto() {
        tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });

    }

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
        txtNombreProducto.setText(productoSeleccionado.getProducto().toString());
        txtReferenciaProducto.setText(productoSeleccionado.getReferencia());
        txtTipoProducto.setText(productoSeleccionado.getTipoProducto().toString());
        txtTallaProducto.setText(productoSeleccionado.getTalla().toString());
        txtColorProducto.setText(productoSeleccionado.getColor().toString());
        txtPrecioProducto.setText(String.valueOf(productoSeleccionado.getPrecio()));
        txtCantidad.setText(String.valueOf(productoSeleccionado.getCantidadDisponible()));

    }

    private void mostrarProducto() {
        txtFiltrarProducto.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarTablas(newValue.toLowerCase());
        });
    }

    private void filtrarTablas(String valorBusqueda) {
        ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();
        for (Producto producto : listaProductos) {
            if (producto.getProducto().toString().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    producto.getReferencia().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    producto.getTipoProducto().toString().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    producto.getTalla().toString().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    producto.getColor().toString().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    String.valueOf(producto.getPrecio()).toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    String.valueOf(producto.getCantidadDisponible()).toLowerCase().contains(valorBusqueda.toLowerCase())) {
                productosFiltrados.add(producto);
            }
        }
        tableProducto.setItems(productosFiltrados);
    }

}
