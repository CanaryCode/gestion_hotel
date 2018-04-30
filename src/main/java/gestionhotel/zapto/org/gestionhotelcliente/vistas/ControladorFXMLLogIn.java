package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import com.sun.imageio.plugins.jpeg.JPEG;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.ConfiguradorIdioma;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgaado
 */
public class ControladorFXMLLogIn implements Initializable {

    @FXML
    Button botonEntrar;

    @FXML
    Label MensajeError;

    @FXML
    TextField usuario;

    @FXML
    PasswordField contraseña;

    @FXML
    ComboBox lenguaje;

    public ControladorFXMLLogIn() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonEntrar.setOnAction((ActionEvent event) -> {
            logicaBoton();
        });
        lenguaje.setItems(FXCollections.observableArrayList(Registro.ListaLenguajes));
        lenguaje.getSelectionModel().selectFirst();
    }

    private void logicaBoton() {
        Locale.setDefault(ConfiguradorIdioma.cambiaIdioma(lenguaje.getSelectionModel().getSelectedItem().toString()));
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaPrincipal();
        obj.ver();
        Ventanas.getVentana("ventanaLogin").close();
        Ventanas.getVentana("ventanaLogin").setActividad(false);
        Ventanas.getListaVentanas().remove(0);
    }
}
