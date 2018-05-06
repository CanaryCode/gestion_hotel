package gestionhotel.zapto.org.gestionhotelcliente.controladores;


import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ConfiguradorMensajes {

    public static void mensajeError(String mensaje, Label etiqueta) {
        etiqueta.setText(mensaje);
        etiqueta.setStyle("-fx-text-fill: red");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), etiqueta);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(4);
        etiqueta.setVisible(true);
        fadeTransition.play();
    }
    public static void mensajeExito(String mensaje, Label etiqueta) {
        etiqueta.setText(mensaje);
        etiqueta.setStyle("-fx-text-fill: green");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), etiqueta);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(4);
        etiqueta.setVisible(true);
        fadeTransition.play();
    }

}
