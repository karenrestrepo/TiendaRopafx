package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;

import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.EmpleadoController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.TransaccionCompraController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Compra;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class TransaccionCompraViewController {

    ObservableList<Compra> listaCompra = FXCollections.observableArrayList();
    Compra compraSeleccionado;
    Tienda tienda;
    TransaccionCompraController compraController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCompra;

    @FXML
    private Button btnCrearCompra;

    @FXML
    private Button btnEliminarCompra;

    @FXML
    private SplitMenuButton mbtnColor;

    @FXML
    private SplitMenuButton mbtnProducto;

    @FXML
    private SplitMenuButton mbtnTalla;

    @FXML
    private TableView<Compra> tableCompra;

    @FXML
    private TableColumn<Compra, String> tcCantidad;

    @FXML
    private TableColumn<Compra, String> tcCedulaCliente;

    @FXML
    private TableColumn<Compra, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<Compra, String> tcCodigoCompra;

    @FXML
    private TableColumn<Compra, String> tcColor;

    @FXML
    private TableColumn<Compra, String> tcFecha;

    @FXML
    private TableColumn<Compra, String> tcNombreCliente;

    @FXML
    private TableColumn<Compra, String> tcNombreEmpleado;

    @FXML
    private TableColumn<Compra, String> tcProducto;

    @FXML
    private TableColumn<Compra, String> tcTalla;

    @FXML
    private TableColumn<Compra, String> tcTipoProducto;

    @FXML
    private TextField txtCantidadProductos;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtCodigoCompra;

    @FXML
    private TextField txtColorProducto;

    @FXML
    private TextField txtFechaCompra;

    @FXML
    private TextField txtFiltrarCompra;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtProducto;

    @FXML
    private TextField txtTallaProducto;

    @FXML
    private TextField txtTipoProducto;


    @FXML
    void onActualizarCompra(ActionEvent event) {

    }

    @FXML
    void onAgregarCompra(ActionEvent event) {

    }

    @FXML
    void onEliminararCompra(ActionEvent event) {

    }

    @FXML
    void initialize() {
        compraController = new TransaccionCompraController();
        iniView();

    }

    private void iniView() {
        iniDataBinding();
        obtenerCompras();
        tableCompra.getItems().clear();
        tableCompra.setItems(listaCompra);
        listenerSelectionCompra();
        mostrarCompra();
    }

    private void iniDataBinding() {
        tcCodigoCompra.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoCompra()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(formatDate(cellData.getValue().getFechaCompra())));
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().clienteAsociado.getNombreCompleto()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().clienteAsociado.getCedula()));
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().empleadoAsociado.getNombreCompleto()));
        tcCedulaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().empleadoAsociado.getCedula()));

    }

    private String formatDate(Date fechaCompra) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ZonedDateTime.ofInstant(fechaCompra.toInstant(),
                ZoneId.systemDefault()).toLocalDate());
    }

    private void obtenerCompras() {
        listaCompra.addAll(compraController.obtenerEmpleados());
    }

    private void listenerSelectionCompra() {
    }

    private void mostrarCompra() {
    }

}