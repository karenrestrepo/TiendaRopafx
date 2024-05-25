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
import javafx.scene.control.*;


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
        agregarCompra();

    }

    private void agregarCompra() {
        if (validarFormularioCompra()) {
            if (mostrarMensajeConfirmacion("¿Desea crear esta compra?")) {
                Compra compra = construirDatosCompra();
                if (compraController.crearCompra(compra)) {
                    listaCompra.add(compra);
                    mostrarMensaje("Notificación compra", "Compra creada", "La compra se ha creado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposCompra();

                }else{
                    mostrarMensaje("Notificación compra", "Compra no creada", "La compra no se ha creado con éxito", Alert.AlertType.ERROR);
                }
            }
        }else {
            mostrarMensaje("Notificación compra", "Compra no creada", "La compra no se ha creado con éxito", Alert.AlertType.ERROR);
        }
    }

    private Compra construirDatosCompra() {

    }

    private void limpiarCamposCompra() {
        txtNombreEmpleado.setText("");
        txtCedulaEmpleado.setText("");
        txtCodigoCompra.setText("");
        txtFechaCompra.setText("");
        txtNombreCliente.setText("");
        txtCedulaCliente.setText("");
        txtProducto.setText("");
        txtTipoProducto.setText("");
        txtTallaProducto.setText("");
        txtColorProducto.setText("");
        txtCantidadProductos.setText("");
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
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
        tableCompra.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            compraSeleccionado = newSelection;
            mostrarInformacionCompra(compraSeleccionado);
        });
    }

    private void mostrarInformacionCompra(Compra compraSeleccionado) {
        txtCodigoCompra.setText(compraSeleccionado.getCodigoCompra());
        txtFechaCompra.setText(compraSeleccionado.getCodigoCompra());
        txtCedulaCliente.setText(compraSeleccionado.getClienteAsociado().getNombreCompleto());
        txtCedulaCliente.setText(compraSeleccionado.getClienteAsociado().getCedula());
        txtNombreEmpleado.setText(compraSeleccionado.getEmpleadoAsociado().getNombreCompleto());
        txtCedulaEmpleado.setText(compraSeleccionado.getEmpleadoAsociado().getCedula());
        txtProducto.setText(compraSeleccionado.getProductoAsociado().getNombre());
        txtTipoProducto.setText(compraSeleccionado.getProductoAsociado().getTipoProducto().name());
        txtTallaProducto.setText(compraSeleccionado.getProductoAsociado().getTalla().name());
        txtColorProducto.setText(compraSeleccionado.getProductoAsociado().getColor().name());
        txtCantidadProductos.setText(String.valueOf(compraSeleccionado.getDetalleCompra().getCantidadComprado()));

    }

    private void mostrarCompra() {
        txtFiltrarCompra.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarTablas(newValue.toLowerCase());
        });
    }

    private void filtrarTablas(String valorBusqueda) {
        ObservableList<Compra> comprasFiltrados = FXCollections.observableArrayList();
        for (Compra compra : listaCompra) {
            if (compra.getCodigoCompra().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getFechaCompra().toString().contains(valorBusqueda.toLowerCase()) ||
                    compra.getClienteAsociado().getNombreCompleto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getClienteAsociado().getCedula().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getEmpleadoAsociado().getNombreCompleto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getEmpleadoAsociado().getCedula().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getProductoAsociado().getNombre().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getProductoAsociado().getTipoProducto().name().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getProductoAsociado().getTalla().name().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compra.getProductoAsociado().getColor().name().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    Integer.toString(compra.getDetalleCompra().getCantidadComprado()).contains(valorBusqueda)) {
                comprasFiltrados.add(compra);
            }
        }
        tableCompra.setItems(comprasFiltrados);
    }

}