package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ConfiguradorMensajes;
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
public class ControladorLogIn implements Initializable {

    @FXML
    Button botonEntrar;

    @FXML
    Label mensaje;

    @FXML
    TextField usuario;

    @FXML
    PasswordField password;

    @FXML
    ComboBox lenguaje;

    public ControladorLogIn() {
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
        if (loginValido()) {
            ConfiguradorMensajes.mensajeExito("Usuario y contraseña validos", mensaje);
            Locale.setDefault(ConfiguradorIdioma.cambiaIdioma(lenguaje.getSelectionModel().getSelectedItem().toString()));
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaPrincipal();
            if (obj != null) {
                 obj.getVentana().focusedProperty().addListener((observable) -> {
                if(!obj.getVentana().isFocused()){
                    obj.getVentana().setOpacity(1);
                }
            });
                obj.ver();
                Ventanas.getVentana(Ventanas.LOGIN).close();
                Ventanas.getVentana(Ventanas.LOGIN).setActividad(false);
                Ventanas.getListaVentanas().remove(0);
            }
        } else {
            ConfiguradorMensajes.mensajeError("Usuario o contraseña incorrectos", mensaje);
        }
    }

    private boolean loginValido() {
        boolean resultado = false;
        String usuario = this.usuario.getText();
        String passw = this.password.getText();
        if (usuario.equals("") && passw.equals("")) {
            resultado = true;
        }
        return resultado;
    }
}
