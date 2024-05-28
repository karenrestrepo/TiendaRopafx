package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.EmpleadoController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Command.EliminarEmpleadoCommand;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Memento.EmpleadoMemento;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class EmpleadoViewController {
    ObservableList<Empleado> listaEmpleado = FXCollections.observableArrayList();
    Empleado empleadoSeleccionado;
    Tienda tienda;
    EmpleadoController empleadoController;
    EmpleadoMemento empleadoMemento;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private Button btnAgregarEmpleado;
    @FXML
    private Button btnDeshacerAccion;
    @FXML
    private Button btnRehacerAccion;
    @FXML
    private Button btnFiltrar;

    @FXML
    private Button btnSalarioMayor;

    @FXML
    private Button btnTipoContrato;
    @FXML
    private TableView<Empleado> tableEmpleado;
    @FXML
    private TableColumn<Empleado, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcCorreoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcHorasTrabajoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcNombreEmpleado;
    @FXML
    private TableColumn<Empleado, String> tcSalarioEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcSexoEmpleado;
    @FXML
    private TableColumn<Empleado, String> tcTelefonoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcTipoContratoEmpleado;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtCorreoEmpleado;

    @FXML
    private TextField txtHorasTrabajoEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtSalarioEmpleado;
    @FXML
    private TextField txtSexoEmpleado;
    @FXML
    private TextField txtTipoContratoRequerido;
    @FXML
    private TextField txtSalarioMayor;
    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtTelefonoEmpleado;

    @FXML
    private TextField txtTipoContrato;

    @FXML
    void initialize() {
        empleadoController = new EmpleadoController();
        iniView();
    }

    private void iniView() {
        iniDataBinding();
        obtenerEmpleados();
        tableEmpleado.getItems().clear();
        tableEmpleado.setItems(listaEmpleado);
        listenerSelectionEmpleado();
        mostrarEmpleado();
    }

    @FXML
    void onActualizarEmpleado(ActionEvent event) {
        actualizarEmpleado();
    }

    @FXML
    void onDeshacerAccion(ActionEvent event) {
        deshacerAccion();
    }

    @FXML
    void onRehacerAccion(ActionEvent event) {
        rehacerAccion();
    }

    @FXML
    void onFiltrar(ActionEvent event) {
        filtrarValor();

    }

    private void filtrarValor() {
    }

    @FXML
    void onSalarioMayor(ActionEvent event) {
        obtenerSalarioMayor();

    }

    private void obtenerSalarioMayor() {
        String salarioTexto = txtSalarioMayor.getText();
        if (!salarioTexto.isEmpty()) {
            int salarioBase = Integer.parseInt(salarioTexto);
            List<Empleado> empleadosFiltrados = empleadoController.filtrarEmpleadosPorSalario(salarioBase);
            ObservableList<Empleado> empleadosObservables = FXCollections.observableArrayList(empleadosFiltrados);
            tableEmpleado.setItems(empleadosObservables);
        } else {
            mostrarMensaje("Error", "Valor inválido", "Por favor, ingrese un valor para el salario.", Alert.AlertType.ERROR);
        }

    }

    @FXML
    void onTipoContrato(ActionEvent event) {
        mostrarTipoContrato();

    }
    private void mostrarTipoContrato() {
        String tipoContrato = txtTipoContratoRequerido.getText();
        if (!tipoContrato.isEmpty()) {
            List<Empleado> empleadosFiltrados = empleadoController.filtrarEmpleadosPorTipoContrato(tipoContrato);
            ObservableList<Empleado> empleadosObservables = FXCollections.observableArrayList(empleadosFiltrados);
            tableEmpleado.setItems(empleadosObservables);
        } else {
            mostrarMensaje("Error", "Valor vacío", "Por favor, ingrese un tipo de contrato.", Alert.AlertType.ERROR);
        }
    }

    private void actualizarEmpleado() {
        if (empleadoSeleccionado != null) {
            Empleado empleadoActualizado = construirDatosEmpleado();
            if (empleadoController.actualizarEmpleado(empleadoActualizado)) {
                int index = listaEmpleado.indexOf(empleadoSeleccionado);
                listaEmpleado.set(index, empleadoActualizado);
                mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación empleado", "Error al actualizar", "No se pudo actualizar el empleado", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void onEliminarEmpleado(ActionEvent event) {
        eliminarEmpleado();
    }

    @FXML
    void onAgregarEmpleado(ActionEvent event) {
        agregarEmpleado();

    }

    private void agregarEmpleado() {
        if (validarFormularioEmpleado()) {
            if (mostrarMensajeConfirmacion("¿Desea agregar este empleado?")) {
                Empleado empleado = construirDatosEmpleado();
                if (empleadoController.agregarEmpleado(empleado)) {
                    listaEmpleado.add(empleado);
                    mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEmpleado();

                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
                }
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



    private void mostrarEmpleado() {
        txtFiltrar.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarTablas(newValue.toLowerCase());
        });
    }

    private void filtrarTablas(String valorBusqueda) {
        ObservableList<Empleado> empleadosFiltrados = FXCollections.observableArrayList();
        for (Empleado empleado : listaEmpleado) {
            if (empleado.getNombreCompleto().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getCedula().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getSexo().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getTelefono().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getCorreo().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getSalario().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getTipoContrato().toLowerCase().contains(valorBusqueda.toLowerCase()) ||
                    empleado.getHorasTrabajo().toLowerCase().contains(valorBusqueda.toLowerCase())) {
                empleadosFiltrados.add(empleado);
            }
        }
        tableEmpleado.setItems(empleadosFiltrados);
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

    private void obtenerEmpleados() {
        listaEmpleado.addAll(empleadoController.obtenerEmpleados());

    }


    private void iniDataBinding() {
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

    private void eliminarEmpleado() {
        if (mostrarMensajeConfirmacion("¿Desea eliminar este empleado?")) {
            EliminarEmpleadoCommand eliminarEmpleadoCommand = new EliminarEmpleadoCommand(empleadoController, empleadoSeleccionado, empleadoSeleccionado.getCedula());
            empleadoController.executeCommand(eliminarEmpleadoCommand);
            String cedulaEmpleadoEliminado = txtCedulaEmpleado.getText();
            empleadoController.deleteEmpleado(cedulaEmpleadoEliminado);
            listaEmpleado.removeIf(empleado -> empleado.getCedula().equals(cedulaEmpleadoEliminado));
            tableEmpleado.refresh();
            mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
        }
    }

    private void deshacerAccion() {
        if (!empleadoController.isExecutedCommandsEmpty()) {
            empleadoController.undoCommand();
            empleadoSeleccionado = empleadoController.obtenerEmpleados().getLast();
            listaEmpleado.add(empleadoSeleccionado);
            tableEmpleado.refresh();
        } else {
            mostrarMensaje("No hay comandos para deshacer",
                    "No hay comandos para deshacer",
                    "No puedes deshacer un comando porque no hay comandos que hayan sido ejecutados previamente.",
                    Alert.AlertType.WARNING);
        }
    }

    private void rehacerAccion() {
        if (!empleadoController.isUndoneCommandsEmpty()) {
            empleadoController.redoCommand();
            empleadoSeleccionado = empleadoController.obtenerEmpleados().getLast();
            listaEmpleado.removeIf(empleado -> empleado.getCedula().equals(empleadoSeleccionado.getCedula()));
            tableEmpleado.refresh();
        } else {
            mostrarMensaje("No hay comandos para rehacer",
                    "No hay comandos para rehacer",
                    "No puedes rehacer un comando porque no hay comandos que hayan sido deshechos previamente.",
                    Alert.AlertType.WARNING);
        }
    }
}
