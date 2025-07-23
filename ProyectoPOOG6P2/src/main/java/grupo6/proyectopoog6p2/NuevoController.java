/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo6.proyectopoog6p2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import grupo6.proyectopoog6p2.modelo.Cliente;
/**
 * FXML Controller class
 *
 * @author mbravop
 */
public class NuevoController {


    @FXML
    private Label lblAnadirPersona;
    @FXML
    private Label lblCedulaAnadir;
    @FXML
    private Label lblNombreAnadir;
    @FXML
    private Label lblTelefonoAnadir;
    @FXML
    private Label lblEmailAnadir;
    @FXML
    private Label lblDatosAnadir;
    @FXML
    private TextField txtCedulaAnadir;
    @FXML
    private TextField txtNombreAnadir;
    @FXML
    private TextField txtTelefonoAnadir;
    @FXML
    private TextField txtEmailAnadir;
    @FXML
    private TextField txtDatosAnadir;
    @FXML
    private Button btnCancelarAnadir;
    @FXML
    private Button btnGuardarAnadir;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
        txtDatosAnadir.setPromptText("cedula - nombre");
    }    
    
    @FXML
    private void switchToMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        fxmlLoader.setController(null);
        
        MenuController mc = new MenuController();
        fxmlLoader.setController(mc);
        Parent root = (Parent) fxmlLoader.load();
        

        App.changeRoot(root);
    }

   @FXML
private void guardarAnadir() throws IOException {
    String nombre = txtNombreAnadir.getText();
    String cedula = txtCedulaAnadir.getText();
    String email  = txtEmailAnadir.getText();

    Validador v1 = new ValidadorNombre();
    Validador v2 = new ValidadorCedula();
    Validador v3 = new ValidadorEmail();

    v1.setSiguiente(v2);
    v2.setSiguiente(v3);

    if (!v1.validar(nombre) || !v1.validar(cedula) || !v1.validar(email)) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setContentText("Datos inválidos");
        alerta.showAndWait();
        return;
    }
}
}
