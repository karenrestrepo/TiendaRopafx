package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;

import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Optional;
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
        actualizarCompra();
    }

    private void actualizarCompra() {
        if (compraSeleccionado != null) {
            CompraDto compraDtoActualizado = buildCompraDto();
            if (compraController.actualizarCompra(compraDtoActualizado)) {
                int index = listaCompra.indexOf(compraSeleccionado);
                listaCompra.set(index, compraDtoActualizado);
                mostrarMensajeNotaCredito(compraDtoActualizado);
            } else {
                mostrarMensaje("Notificación empleado", "Error al actualizar", "No se pudo actualizar el empleado", Alert.AlertType.ERROR);
            }
        }
    }

    private void mostrarMensajeNotaCredito(CompraDto compraDtoActualizado) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Actualización de la compra realizada");
        alert.setHeaderText("Información de la nota crédito:");


        String contenido = "Fecha de compra: " + compraDtoActualizado.fechaCompra() + "\n" +
                "Cliente" + "\n" + "Nombre: " + compraDtoActualizado.nombreCliente() + "\n" +
                "Cédula: " + compraDtoActualizado.cedulaCliente() + "\n" +
                "Empleado" + "\n" + "Nombre: " + compraDtoActualizado.nombreEmpleado() + "\n" +
                "Cédula: " + compraDtoActualizado.cedulaEmpleado() + "\n" +
                "Producto: " + compraDtoActualizado.producto() + "\n" +
                "Tipo de producto: " + compraDtoActualizado.tipoProducto() + "\n" +
                "Talla: " + compraDtoActualizado.talla() + "\n" +
                "Color: " + compraDtoActualizado.color() + "\n" +
                "Cantidad: " + compraDtoActualizado.cantidadProductos() + "\n" +
                "Precio: $" + compraController.calcularPrecioNota(compraDtoActualizado);

        alert.setContentText(contenido);

        ButtonType enviarCorreoButton = new ButtonType("Enviar nota crédito por correo");
        alert.getButtonTypes().add(enviarCorreoButton);

        alert.showAndWait().ifPresent(response -> {
            if (response == enviarCorreoButton) {
                mostrarMensaje("Notificación envío de nota crédito", "Nota crédito electrónica", "La nota crédito se ha enviado correctamente al correo registrado", Alert.AlertType.INFORMATION);
            }
        });
    }

    @FXML
    void onAgregarCompra(ActionEvent event) {
        agregarCompra();

    }

    private void agregarCompra() {
        if (validarFormularioCompra()) {
            if (mostrarMensajeConfirmacion("¿Desea crear esta compra?")) {
                CompraDto compraDto = buildCompraDto();
                Compra compra = compraController.agregarCompra(compraDto);
                listaCompra.add(buildCompraDtoo(compra));
                mostrarMensajeFactura(compra);
                    limpiarCamposCompra();

                }else{
                    mostrarMensaje("Notificación compra", "Compra no creado", "La compra no se ha creado con éxito", Alert.AlertType.ERROR);
                }
            } else {
            mostrarMensaje("Notificación compra", "Compra no creado", "La compra no se ha creado con éxito", Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensajeFactura(Compra compra) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Compra realizada");
        alert.setHeaderText("Información de la compra:");


        String contenido = "Fecha de compra: " + compra.getFechaCompra() + "\n" +
                "Cliente" + "\n" + "Nombre: " + compra.getClienteAsociado().getNombreCompleto() + "\n" +
                "Cédula: " + compra.getClienteAsociado().getCedula() + "\n" +
                "Empleado" + "\n" + "Nombre: " + compra.getEmpleadoAsociado().getNombreCompleto() + "\n" +
                "Cédula: " + compra.getEmpleadoAsociado().getCedula() + "\n" +
                "Producto: " + compra.getProductoAsociado().getProducto() + "\n" +
                "Tipo de producto: " + compra.getProductoAsociado().getTipoProducto() + "\n" +
                "Talla: " + compra.getProductoAsociado().getTalla() + "\n" +
                "Color: " + compra.getProductoAsociado().getColor() + "\n" +
                "Cantidad: " + compra.getDetalleCompra().getCantidadComprado() + "\n" +
                "Precio: $" + compraController.calcularPrecio(compra);

        alert.setContentText(contenido);

        ButtonType enviarCorreoButton = new ButtonType("Enviar factura por correo");
        alert.getButtonTypes().add(enviarCorreoButton);

        alert.showAndWait().ifPresent(response -> {
            if (response == enviarCorreoButton) {
                mostrarMensaje("Notificación envío de factura", "Factura electrónica de venta", "La factura se ha enviado correctamente al correo registrado", Alert.AlertType.INFORMATION);
            }
        });
    }


    private CompraDto buildCompraDtoo(Compra compra) {
        return new CompraDto(
                compra.getCodigoCompra(),
                compra.getFechaCompra().toString(),
                compra.clienteAsociado.getNombreCompleto(),
                compra.clienteAsociado.getCedula(),
                compra.empleadoAsociado.getNombreCompleto(),
                compra.empleadoAsociado.getCedula(),
                compra.productoAsociado.getProducto().toString(),
                compra.productoAsociado.getTipoProducto().toString(),
                compra.productoAsociado.getTalla().toString(),
                compra.productoAsociado.getColor().toString(),
                Integer.toString(compra.detalleCompra.getCantidadComprado())
        );
    }

    private boolean validarFormularioCompra() {
        if (txtCodigoCompra.getText().isEmpty() ||
        txtFechaCompra.getText().isEmpty() ||
        txtNombreCliente.getText().isEmpty() ||
        txtCedulaCliente.getText().isEmpty() ||
        txtNombreEmpleado.getText().isEmpty() ||
        txtCedulaEmpleado.getText().isEmpty() ||
        txtProducto.getText().isEmpty() ||
        txtTipoProducto.getText().isEmpty() ||
        txtTallaProducto.getText().isEmpty() ||
        txtColorProducto.getText().isEmpty() ||
        txtCantidadProductos.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setHeaderText(null);
        alert1.setTitle("Confirmación");
        alert1.setContentText(mensaje);
        Optional<ButtonType> action = alert1.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        }else {
            return false;
        }
    }

    private CompraDto buildCompraDto() {
        return new CompraDto(
                txtCodigoCompra.getText(),
                txtFechaCompra.getText(),
                txtNombreCliente.getText(),
                txtCedulaCliente.getText(),
                txtNombreEmpleado.getText(),
                txtCedulaEmpleado.getText(),
                txtProducto.getText(),
                txtTipoProducto.getText(),
                txtTallaProducto.getText(),
                txtColorProducto.getText(),
                txtCantidadProductos.getText()
        );
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
        eliminararCompra();

    }

    private void eliminararCompra() {
        String codigoCompraEliminado = txtCodigoCompra.getText();
        compraController.deleteCompra(codigoCompraEliminado);
        listaCompra.removeIf(compraDto -> compraDto.codigoCompra().equals(codigoCompraEliminado));
        mostrarMensaje("Notificación compra", "Compra eliminada", "La compra se ha eliminado con éxito, a su correo le llegará la nota crédito electrónica reversando la factura", Alert.AlertType.INFORMATION);

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
        txtNombreCliente.setText(compraSeleccionado.nombreCliente());
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
                    compraDto.cantidadProductos().toLowerCase().contains(valorBusqueda.toLowerCase())) {
                comprasFiltrados.add(compraDto);
            }
        }
        tableCompra.setItems(comprasFiltrados);
    }

}

