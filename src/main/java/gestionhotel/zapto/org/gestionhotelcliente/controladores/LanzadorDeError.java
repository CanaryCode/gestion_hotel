/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class LanzadorDeError {
public static void lanzarErrorUsuario(String mensaje){
    Alert alert = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un error grave,\npongase en contacto con el suministrador de software:\n"
            + "Enigma Software S.L.N.E.\nCapture la pantalla con este error para informar al servicio técnico.\n"
            + "El error es este:\n"+mensaje, ButtonType.CLOSE);
    alert.show();
}
}
