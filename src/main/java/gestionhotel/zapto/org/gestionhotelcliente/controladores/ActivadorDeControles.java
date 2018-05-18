/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ActivadorDeControles {
/**
 * sirve para los cuando se introduce texto en alguno "textInputControl" pasados
 * por parámetro se active una lista de controles pasados por parametros. si 
 * todos los "TextInputControl" estan vacios los controles
 * @param ListaTic lista de "textInputControl" que se quiere poner a la escucha.
 * @param controles lista de controles que se quiere activar o desactivar
 */
    public static void addActivador(final List<TextInputControl> ListaTic, Control... controles) {
        //recorro el array de "TextInputControl" para ponerlo a la escucha
        for (TextInputControl textInputControl : ListaTic) {
            //pongo a la escucha todos los tic
            textInputControl.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                //inicializo variable
                boolean hayAlgoEscrito = false;
                //recorro lista de tic
                for (TextInputControl tIC : ListaTic) {
                    //si el tic no soy yo y
                    //si en alguno de los textos de los tic hay algo escrito
                    if (tIC != textInputControl && !tIC.getText().equals("")) {
                            //hay "algoescrito" es verdad y termina
                            hayAlgoEscrito = true;
                        break;
                    }
                 
                }
                //si el nuevo valor que escribí no deja el tic vacio
                if (!newValue.equals("")) {
                    //recorre todos los controles y ponlos activos
                    for (Control control : controles) {
                        control.setDisable(false);
                    }
                    //si el nuevo valor que escribi deja el tic vacio y todos los demas
                    //estan vacios
                } else if (newValue.equals("") && hayAlgoEscrito == false) {
                      //recorre todos los controles y ponlos no activos.
                    for (Control control : controles) {
                        control.setDisable(true);
                    }
                }
            });
        };
    }
}
