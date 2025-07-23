/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import grupo6.proyectopoog6p2.modelo.Actividad;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class MenuActividadController implements IObserver {

    @FXML
    private TableColumn<Actividad, String> colActividad;
    @FXML
    private TableColumn<Actividad, String> colCliente;
    @FXML
    private TableColumn<Actividad, String> colFallos;
    @FXML
    private TableColumn<Actividad, String> colFecha;
    @FXML
    private TableColumn<Actividad, String> colTiempo;
    @FXML
    private TableView<Actividad> tvActividades;

    private ActividadManager manager = new ActividadManager();

    @FXML
    public void initialize() {
        colActividad.setCellValueFactory(new PropertyValueFactory<>("actividad"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colFallos.setCellValueFactory(new PropertyValueFactory<>("fallos"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));

        manager.addObserver(this);
        manager.cargarDesdeArchivo(App.pathActividades);
    }

    @Override
    public void update() {
        List<Actividad> lista = manager.getActividades();
        tvActividades.getItems().setAll(lista);
    }
}
