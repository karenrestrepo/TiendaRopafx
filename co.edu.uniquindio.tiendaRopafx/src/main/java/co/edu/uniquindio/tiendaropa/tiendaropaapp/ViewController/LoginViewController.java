package co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginViewController {

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

    }

    @FXML
    void onRegistrarUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnIniciarsesionUsuario != null : "fx:id=\"btnIniciarsesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnRegistrarUsuario != null : "fx:id=\"btnRegistrarUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContrasenaUsuario != null : "fx:id=\"txtContrasenaUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContraseñaSesionUsuario != null : "fx:id=\"txtContraseñaSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtCorreoSesionUsuario != null : "fx:id=\"txtCorreoSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtCorreoUsuario != null : "fx:id=\"txtCorreoUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtTipoSesionUsuario != null : "fx:id=\"txtTipoSesionUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtTipoUsuario != null : "fx:id=\"txtTipoUsuario\" was not injected: check your FXML file 'Login.fxml'.";

    }
    //    @FXML
//    private void handleLoginAction() {
//        String username = usernameField.getText();
//        String password = passwordField.getText();
//
//        // Aquí se implementaría la lógica de autenticación
//        if (username.equals("cliente") && password.equals("1234")) {
//            // Cargar la interfaz del cliente
//            loadInterface("/com/example/ClienteView.fxml", "Cliente");
//        } else if (username.equals("empleado") && password.equals("1234")) {
//            // Cargar la interfaz del empleado
//            loadInterface("/com/example/EmpleadoView.fxml", "Empleado");
//        } else {
//            showAlert("Error", "Invalid username or password");
//        }
//    }
//
//    @FXML
//    private void handleRegisterAction() {
//        // Aquí iría la lógica de registro
//        showAlert("Registro", "Función de registro aún no implementada.");
//    }
//
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    private void loadInterface(String fxmlPath, String title) {
//        try {
//            Stage stage = (Stage) usernameField.getScene().getWindow();
//            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
//            stage.setTitle(title);
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
