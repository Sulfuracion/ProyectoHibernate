package org.example.proyectohibernate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

import static org.example.proyectohibernate.Usuario.*;
import static org.example.proyectohibernate.UsuarioDB.crearUsuarioDB;
import static org.example.proyectohibernate.UsuarioDB.eliminarUsuarioDB;


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
    private Usuario usuario;



    public void eliminarUsuario(ActionEvent event) {
        eliminarUsuarioDB(usuario);
    }

    public void crearUsuario(ActionEvent event) {
        UsuarioDB.crearUsuarioDB(nombreArea.getText(), apellidoArea.getText(), direccionArea.getText());
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
