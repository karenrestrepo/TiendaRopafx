package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.ClienteController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Cliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class ClienteViewController {
    ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
    Cliente clienteSeleccionado;
    Tienda tienda;
    ClienteController clienteController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnFiltrar;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> tcCedulaCliente;

    @FXML
    private TableColumn<Cliente, String> tcFechaUltimaCompraCliente;

    @FXML
    private TableColumn<Cliente, String> tcMetodoPagoCliente;

    @FXML
    private TableColumn<Cliente, String> tcNombreCliente;

    @FXML
    private TableColumn<Cliente, String> tcProductosCompradosCliente;

    @FXML
    private TableColumn<Cliente, String> tcSexoCliente;

    @FXML
    private TableColumn<Cliente, String> tcTelefonoCliente;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtFechaUltimaCompraCliente;

    @FXML
    private TextField txtMetodoPagoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtProductosCompradosCliente;

    @FXML
    private TextField txtSexoCliente;

    @FXML
    private TextField txtFiltrarCliente;

    @FXML
    private TextField txtTelefonoCliente;


    @FXML
    void onActualizarCliente(ActionEvent event) {
        actualizarCliente();

    }

    private void actualizarCliente() {
        if (clienteSeleccionado != null) {
            Cliente clienteActualizado = construirDatosCliente();
            if (clienteController.actualizarEmpleado(clienteActualizado)) {
                int index = listaCliente.indexOf(clienteSeleccionado);
                listaCliente.set(index, clienteActualizado);
                mostrarMensaje("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación cliente", "Error al actualizar", "No se pudo actualizar el cliente", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void onEliminararCliente(ActionEvent event) {
        eliminarCliente();

    }

    private void eliminarCliente() {
        String cedulaClienteEliminado = txtCedulaCliente.getText();
        clienteController.deleteCliente(cedulaClienteEliminado);
        listaCliente.removeIf(cliente -> cliente.getCedula().equals(cedulaClienteEliminado));
        mostrarMensaje("Notificación cliente", "Cliente eliminado", "El cliente se ha eliminado con éxito", Alert.AlertType.INFORMATION);

    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();

    }

    private void agregarCliente() {
        if (validarFormulario()) {
            Cliente cliente = construirDatosCliente();
            if (clienteController.agregarCliente(cliente)) {
                listaCliente.add(cliente);
                mostrarMensaje("Notificación cliente", "Cliente creado", "El cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposCliente();

            }else{
                mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", Alert.AlertType.ERROR);

            }
        }else{
            mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", Alert.AlertType.ERROR);

        }



    }

    private void limpiarCamposCliente() {
        txtNombreCliente.setText("");
        txtCedulaCliente.setText("");
        txtSexoCliente.setText("");
        txtTelefonoCliente.setText("");
        txtProductosCompradosCliente.setText("");
        txtFechaUltimaCompraCliente.setText("");
        txtMetodoPagoCliente.setText("");
    }

    private boolean validarFormulario() {
        if (txtNombreCliente.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private Cliente construirDatosCliente() {
        return Cliente.builder()
                .nombreCompleto(txtNombreCliente.getText())
                .cedula(txtCedulaCliente.getText())
                .sexo(txtSexoCliente.getText())
                .telefono(txtTelefonoCliente.getText())
                .productosComprado(txtProductosCompradosCliente.getText())
                .fechaUltimaCompra(txtFechaUltimaCompraCliente.getText())
                .metodoPago(txtMetodoPagoCliente.getText())
                .build();
    }


    @FXML
    void initialize() {
        clienteController = new ClienteController();
        iniView();


    }

    private void iniView() {
        iniDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaCliente);
        listenerSelectionCliente();
        mostrarCliente();



    }

    private void mostrarCliente() {
        txtFiltrarCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarTablas(newValue.toLowerCase());
        });
    }

    private void filtrarTablas(String valorBusqueda) {
        ObservableList<Cliente> clientesFiltrados = FXCollections.observableArrayList();
        for (Cliente cliente : listaCliente) {
            if (cliente.getNombreCompleto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getCedula().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getSexo().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getTelefono().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getMetodoPago().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getFechaUltimaCompra().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    cliente.getPrendasCompradas().toLowerCase().contains(valorBusqueda.toLowerCase())) {
                clientesFiltrados.add(cliente);
            }
        }
        tableCliente.setItems(clientesFiltrados);
    }

    private void listenerSelectionCliente() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if (clienteSeleccionado != null) {
            txtNombreCliente.setText(clienteSeleccionado.getNombreCompleto());
            txtCedulaCliente.setText(clienteSeleccionado.getCedula());
            txtSexoCliente.setText(clienteSeleccionado.getSexo());
            txtTelefonoCliente.setText(clienteSeleccionado.getTelefono());
            txtProductosCompradosCliente.setText(clienteSeleccionado.getPrendasCompradas());
            txtFechaUltimaCompraCliente.setText(clienteSeleccionado.getFechaUltimaCompra());
            txtMetodoPagoCliente.setText(clienteSeleccionado.getMetodoPago());
        }
    }

    private void obtenerClientes() {
        listaCliente.addAll(clienteController.obtenerClientes());
    }

    private void iniDataBinding() {
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcSexoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSexo()));
        tcTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tcProductosCompradosCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrendasCompradas()));
        tcFechaUltimaCompraCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaUltimaCompra()));
        tcMetodoPagoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMetodoPago()));
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

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


}
