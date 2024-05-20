module co.edu.uniquindio.tiendaropa.tiendaropaapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.tiendaropa.tiendaropaapp to javafx.fxml;
    opens co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;
    opens co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;
    exports co.edu.uniquindio.tiendaropa.tiendaropaapp.Controller;
    exports co.edu.uniquindio.tiendaropa.tiendaropaapp.ViewController;
    exports co.edu.uniquindio.tiendaropa.tiendaropaapp;
}