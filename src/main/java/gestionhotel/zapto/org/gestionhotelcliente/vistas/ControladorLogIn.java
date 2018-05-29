package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ConfiguradorMensajes;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.ConfiguradorIdioma;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgaado
 */
public class ControladorLogIn implements Initializable {

    @FXML
    Button botonEntrar;

    @FXML
    Label mensajeError, bienvenidos;
    @FXML
    ImageView candado;
    @FXML
    MediaView visualizadorVideo;

    @FXML
    TextField usuario;

    @FXML
    PasswordField password;

    @FXML
    ComboBox lenguaje;
    boolean validado=false;

    public ControladorLogIn() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonEntrar.setOnAction((ActionEvent event) -> {
            logicaBoton();
        });
        usuario.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(usuario, newValue, oldValue, 40);
        });
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(password, newValue, oldValue, 40);
        });
        lenguaje.setItems(FXCollections.observableArrayList(Registro.ListaLenguajes));
        lenguaje.getSelectionModel().selectFirst();
    }

    private void logicaBoton() {
        if (loginValido()&&!validado) {
            validado=true;
            ConfiguradorMensajes.mensajeExito("Usuario y contraseña validos", mensajeError);
            desvaneceCandado();
            evaneceMensaje();
            reproduceVideo();
            Locale.setDefault(ConfiguradorIdioma.cambiaIdioma(lenguaje.getSelectionModel().getSelectedItem().toString()));
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaPrincipal();
            if (obj != null) {
                Timeline t = new Timeline(new KeyFrame(Duration.seconds(8), (event) -> {
                    obj.verReajustable();
                    Ventanas.cerrarVentana(Ventanas.LOGIN);
                }));
                t.play();
            } else {
                ConfiguradorMensajes.mensajeError("Usuario o contraseña incorrectos", mensajeError);
            }
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

    private void desvaneceCandado() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), candado);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private void evaneceMensaje() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), bienvenidos);
        fadeTransition.setToValue(1.0);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setCycleCount(1);
        bienvenidos.setVisible(true);
        fadeTransition.play();
    }
        public void reproduceVideo() {
       
            Media m = new Media(getClass().getResource("/video/videoLogin.mp4").toExternalForm());
            MediaPlayer player = new MediaPlayer(m);
            visualizadorVideo.setMediaPlayer(player);
            visualizadorVideo.setFitWidth(300);
            visualizadorVideo.setFitHeight(560);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.setAutoPlay(true);
        
    }
}
