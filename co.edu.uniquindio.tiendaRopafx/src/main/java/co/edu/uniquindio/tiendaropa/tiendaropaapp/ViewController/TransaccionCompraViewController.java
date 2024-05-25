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
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Dto.CompraDto;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class TransaccionCompraViewController {

    ObservableList<CompraDto> listaCompra = FXCollections.observableArrayList();
    CompraDto compraSeleccionado;
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
    private TableView<CompraDto> tableCompra;

    @FXML
    private TableColumn<CompraDto, String> tcCantidad;

    @FXML
    private TableColumn<CompraDto, String> tcCedulaCliente;

    @FXML
    private TableColumn<CompraDto, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<CompraDto, String> tcCodigoCompra;

    @FXML
    private TableColumn<CompraDto, String> tcColor;

    @FXML
    private TableColumn<CompraDto, String> tcFecha;

    @FXML
    private TableColumn<CompraDto, String> tcNombreCliente;

    @FXML
    private TableColumn<CompraDto, String> tcNombreEmpleado;

    @FXML
    private TableColumn<CompraDto, String> tcProducto;

    @FXML
    private TableColumn<CompraDto, String> tcTalla;

    @FXML
    private TableColumn<CompraDto, String> tcTipoProducto;

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
        tcCodigoCompra.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigoCompra()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaCompra()));
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaCliente()));
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreEmpleado()));
        tcCedulaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaEmpleado()));
        tcProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().producto()));
        tcTipoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipoProducto()));
        tcTalla.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().talla()));
        tcColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().color()));
        tcCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cantidadProductos()));

    }

    private void obtenerCompras() {

        listaCompra.addAll(compraController.obtenerCompras());
    }

    private void listenerSelectionCompra() {
        tableCompra.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            compraSeleccionado = newSelection;
            mostrarInformacionCompra(compraSeleccionado);
        });
    }

    private void mostrarInformacionCompra(CompraDto compraSeleccionado) {
        txtCodigoCompra.setText(compraSeleccionado.codigoCompra());
        txtFechaCompra.setText(compraSeleccionado.fechaCompra());
        txtCedulaCliente.setText(compraSeleccionado.nombreCliente());
        txtCedulaCliente.setText(compraSeleccionado.cedulaCliente());
        txtNombreEmpleado.setText(compraSeleccionado.nombreEmpleado());
        txtCedulaEmpleado.setText(compraSeleccionado.cedulaEmpleado());
        txtProducto.setText(compraSeleccionado.producto());
        txtTipoProducto.setText(compraSeleccionado.tipoProducto());
        txtTallaProducto.setText(compraSeleccionado.talla());
        txtColorProducto.setText(compraSeleccionado.color());
        txtCantidadProductos.setText(compraSeleccionado.cantidadProductos()); 

    }

    private void mostrarCompra() {
        txtFiltrarCompra.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarTablas(newValue.toLowerCase());
        });
    }

    private void filtrarTablas(String valorBusqueda) {
        ObservableList<CompraDto> comprasFiltrados = FXCollections.observableArrayList();
        for (CompraDto compraDto : listaCompra) {
            if (compraDto.codigoCompra().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.fechaCompra().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.nombreCliente().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.cedulaCliente().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.nombreEmpleado().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.cedulaEmpleado().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.producto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.tipoProducto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.talla().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.color().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    compraDto.cantidadProductos().toLowerCase().contains(valorBusqueda)) {
                comprasFiltrados.add(compraDto);
            }
        }
        tableCompra.setItems(comprasFiltrados);
    }

}