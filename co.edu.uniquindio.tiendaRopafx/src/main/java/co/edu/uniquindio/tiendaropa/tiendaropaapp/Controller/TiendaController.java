package co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Cliente;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Factory.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TiendaController {

    ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
    Cliente clienteSeleccionado;
    ObservableList<Empleado> listaEmpleado = FXCollections.observableArrayList();
    Empleado empleadoSeleccionado;
    ModelFactory modelFactory = new ModelFactory();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableView<Empleado> tableEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcCedulaCliente;

    @FXML
    private TableColumn<Empleado, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcCorreoEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcFechaUltimaCompraCliente;

    @FXML
    private TableColumn<Empleado, String> tcHorasTrabajoEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcMetodoPagoCliente;

    @FXML
    private TableColumn<Cliente, String> tcNombreCliente;

    @FXML
    private TableColumn<Empleado, String> tcNombreEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcProductosCompradosCliente;

    @FXML
    private TableColumn<Empleado, String> tcSalarioEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcSexoCliente;

    @FXML
    private TableColumn<Empleado, String> tcSexoEmpleado;

    @FXML
    private TableColumn<Cliente, String> tcTelefonoCliente;

    @FXML
    private TableColumn<Empleado, String> tcTelefonoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcTipoContratoEmpleado;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtCorreoEmpleado;

    @FXML
    private TextField txtFechaUltimaCompraCliente;

    @FXML
    private TextField txtHorasTrabajoEmpleado;

    @FXML
    private TextField txtMetodoPagoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtProductosCompradosCliente;

    @FXML
    private TextField txtSalarioEmpleado;

    @FXML
    private TextField txtSexoCliente;

    @FXML
    private TextField txtSexoEmpleado;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private TextField txtTelefonoEmpleado;

    @FXML
    private TextField txtTipoContrato;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();

    }

    private void agregarCliente() {
        if (validarFormulario()) {
            Cliente cliente = construirDatosCliente();
            if (modelFactory.agregarCliente(cliente)) {
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
    void onAgregarEmpleado(ActionEvent event) {
        agregarEmpleado();

    }

    private void agregarEmpleado() {
        if (validarFormularioEmpleado()) {
            Empleado empleado = construirDatosEmpleado();
            if (modelFactory.agregarEmpleado(empleado)) {
                listaEmpleado.add(empleado);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();

            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);

            }
        }else {
            mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposEmpleado() {
        txtNombreEmpleado.setText("");
        txtCedulaEmpleado.setText("");
        txtSexoEmpleado.setText("");
        txtTelefonoEmpleado.setText("");
        txtCorreoEmpleado.setText("");
        txtSalarioEmpleado.setText("");
        txtTipoContrato.setText("");
        txtHorasTrabajoEmpleado.setText("");
    }

    private boolean validarFormularioEmpleado() {
        if (txtNombreEmpleado.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private Empleado construirDatosEmpleado() {
        return Empleado.builder()
                .nombreCompleto(txtNombreEmpleado.getText())
                .cedula(txtCedulaEmpleado.getText())
                .sexo(txtSexoEmpleado.getText())
                .telefono(txtTelefonoEmpleado.getText())
                .correo(txtCorreoEmpleado.getText())
                .salario(txtSalarioEmpleado.getText())
                .tipoContrato(txtTipoContrato.getText())
                .horasTrabajo(txtHorasTrabajoEmpleado.getText())
                .build();

    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        iniView();


    }

    private void iniView() {
        iniDataBinding();
        obtenerClientes();
        obtenerEmpleados();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaCliente);
        tableEmpleado.getItems().clear();
        tableEmpleado.setItems(listaEmpleado);
        listenerSelectionCliente();
        listenerSelectionEmpleado();


    }

    private void listenerSelectionEmpleado() {
        tableEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionEmpleado(Empleado empleadoSeleccionado) {
        if (empleadoSeleccionado != null) {
            txtNombreEmpleado.setText(empleadoSeleccionado.getNombreCompleto());
            txtCedulaEmpleado.setText(empleadoSeleccionado.getCedula());
            txtSexoEmpleado.setText(empleadoSeleccionado.getSexo());
            txtTelefonoEmpleado.setText(empleadoSeleccionado.getTelefono());
            txtCorreoEmpleado.setText(empleadoSeleccionado.getCorreo());
            txtSalarioEmpleado.setText(empleadoSeleccionado.getSalario());
            txtTipoContrato.setText(empleadoSeleccionado.getTipoContrato());
            txtHorasTrabajoEmpleado.setText(empleadoSeleccionado.getHorasTrabajo());
        }

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

    private void obtenerEmpleados() {
        listaEmpleado.addAll(modelFactory.obtenerEmpleados());

    }

    private void obtenerClientes() {
        listaCliente.addAll(modelFactory.obtenerClientes());
    }

    private void iniDataBinding() {
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcSexoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSexo()));
        tcTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tcProductosCompradosCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrendasCompradas()));
        tcFechaUltimaCompraCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaUltimaCompra()));
        tcMetodoPagoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMetodoPago()));
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        tcCedulaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcSexoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSexo()));
        tcTelefonoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tcCorreoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tcSalarioEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSalario()));
        tcTipoContratoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoContrato()));
        tcHorasTrabajoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHorasTrabajo()));


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
