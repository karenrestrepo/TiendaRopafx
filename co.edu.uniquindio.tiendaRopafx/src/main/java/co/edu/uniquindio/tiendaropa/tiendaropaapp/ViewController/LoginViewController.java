package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.ClienteController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller.EmpleadoController;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Empleado;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.Model.Tienda;
import co.edu.uniquindio.tiendaropa.tiendaropaapp.TiendaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginViewController {
    EmpleadoController empleadoController;
    Tienda tienda;
    ClienteController clienteController;
    Empleado empleado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarsesionUsuario;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private TextField txtContrasenaUsuario;

    @FXML
    private TextField txtContraseñaSesionUsuario;

    @FXML
    private TextField txtCorreoSesionUsuario;

    @FXML
    private TextField txtCorreoUsuario;

    @FXML
    private TextField txtTipoSesionUsuario;

    @FXML
    private TextField txtTipoUsuario;

    @FXML
    void onIniciarsesionUsuario(ActionEvent event) {
        iniciarSesion();
    }

    @FXML
    void onRegistrarUsuario(ActionEvent event) {
        registrarse();
    }

    @FXML
    void initialize() {
        empleadoController = new EmpleadoController();
        clienteController = new ClienteController();
        assert btnIniciarsesionUsuario != null : "fx:id=\"btnIniciarsesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnRegistrarUsuario != null : "fx:id=\"btnRegistrarUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContrasenaUsuario != null : "fx:id=\"txtContrasenaUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContraseñaSesionUsuario != null : "fx:id=\"txtContraseñaSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtCorreoSesionUsuario != null : "fx:id=\"txtCorreoSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtCorreoUsuario != null : "fx:id=\"txtCorreoUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtTipoSesionUsuario != null : "fx:id=\"txtTipoSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtTipoUsuario != null : "fx:id=\"txtTipoUsuario\" was not injected: check your FXML file 'Login.fxml'.";
    }

        @FXML
    private void iniciarSesion() {
        String correo = txtCorreoSesionUsuario.getText();
        String contrasena = txtContraseñaSesionUsuario.getText();
        String tipoUsuario = txtTipoSesionUsuario.getText();

        if (tipoUsuario.equalsIgnoreCase("Empleado")){
            if (contrasena.equalsIgnoreCase("10685") || contrasena.equalsIgnoreCase("41240")){
                loadInterfaceEmpleado("Empleado");
            }else{
                showAlert("Error", "Invalid correo or password");
            }
        } else {
            if (tipoUsuario.equalsIgnoreCase("Cliente")){
                if (contrasena.equalsIgnoreCase("49950") || contrasena.equalsIgnoreCase("41150")){
                    loadInterfaceCliente("Cliente");
                }else{
                    showAlert("Error", "Invalid correo or password");
                }
            }
        }
    }

    @FXML
    private void registrarse() {
        String correo = txtCorreoUsuario.getText();
        String contrasena = txtContrasenaUsuario.getText();
        String tipoUsuario = txtTipoUsuario.getText();

        if (tipoUsuario.equalsIgnoreCase("Empleado")){
            if (contrasena != null){
                loadInterfaceEmpleado("Empleado");
            }else{
                showAlert("Error", "Invalid correo or password");
            }
        } else {
            if (tipoUsuario.equalsIgnoreCase("Cliente")){
                if (contrasena != null){
                    loadInterfaceCliente("Cliente");
                }else{
                    showAlert("Error", "Invalid correo or password");
                }
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadInterfaceEmpleado(String title) {
        try {
            Stage stage = (Stage) txtTipoUsuario.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(TiendaApplication.class.getResource("Tienda.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadInterfaceCliente(String title) {
        try {
            Stage stage = (Stage) txtTipoUsuario.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(TiendaApplication.class.getResource("TransaccionCompra.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
