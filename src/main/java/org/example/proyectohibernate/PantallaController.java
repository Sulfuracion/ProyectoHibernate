package org.example.proyectohibernate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

import static org.example.proyectohibernate.Usuario.*;


public class PantallaController {

    @FXML
    private Button CrearBoton;

    @FXML
    private TableView<Usuario> MostrarTabla;
    @FXML
    private TableColumn<Usuario, String> nombreColumna;
    @FXML
    private TableColumn<Usuario, String> apellidosColumna;
    @FXML
    private TableColumn<Usuario, String> direccionColumna;

    @FXML
    private TextField apellidoArea;

    @FXML
    private TextField direccionArea;

    @FXML
    private Button eliminarBoton;

    @FXML
    private Button modificarBoton;

    @FXML
    private TextField nombreArea;


    private UsuarioDB usuarioDB;



    public void eliminarUsuario(ActionEvent event) {
        //eliminarUsuarioDB();
    }

    public void crearUsuario(ActionEvent event) {
       crearUsuarioDB(nombreArea.getText(), apellidoArea.getText(), direccionArea.getText());
    }

    public void modificarUsuario(ActionEvent event) {
        //modificarUsuarioDB();
    }

    public void cargarUsuariosEnTablas(){
        List<Usuario> usuarios=usuarioDB.obtenerUsuarios();

        MostrarTabla.getItems().clear();//limpia la tabla

        MostrarTabla.getItems().addAll(usuarios);

    }


}
