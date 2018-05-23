/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Sistema;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.jboss.jandex.Main;
import sun.audio.AudioPlayer;

/**
 * FXML Controller class
 *
 * @author deico
 */
public class ControladorQuienesSomos implements Initializable {

    @FXML
    private Label titulo;
    @FXML
    private Hyperlink enlaceEmail, enlaceWeb;
    @FXML
    private MediaView visualizadorVideo;

    private final String direccionEmail = "mailto:atencionalcliente@enigmasoftware.com", direccionWeb = "http://enigmaSofware.com";
    HostServices hostServices;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaAnimacion();
        enlaceEmail.setOnAction((event) -> {
            codigoEmail();
        });
        enlaceWeb.setOnAction((event) -> {
            codigoWeb();
        });
    }

    private void iniciaAnimacion() {

    }

    private void codigoEmail() {
        Sistema.getHostServicesDelegate().showDocument(direccionEmail);
    }

    private void codigoWeb() {
        Sistema.getHostServicesDelegate().showDocument(direccionWeb);
    }

    public void reproduceVideo() {
       
            Media m = new Media(getClass().getResource("/video/videoFondo.mp4").toExternalForm());
            MediaPlayer player = new MediaPlayer(m);
            visualizadorVideo.setMediaPlayer(player);
            visualizadorVideo.fitWidthProperty().bind(Ventanas.getVentana(Ventanas.QUIENES_SOMOS).getScene().widthProperty());
            visualizadorVideo.fitHeightProperty().bind(Ventanas.getVentana(Ventanas.QUIENES_SOMOS).getScene().widthProperty());
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.setAutoPlay(true);
            
        
    }
}
