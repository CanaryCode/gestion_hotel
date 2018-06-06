package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class LanzadorDeAvisos {
 String mensaje;
 
    public static Alert mensajeError(String mensaje) {
        Alert a = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.CLOSE);
        a.show();
        return a;
    }
    public static Alert mensajeAviso(String mensaje) {
        Alert a = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.CLOSE);
        a.show();
        return a;
    }
    public static Alert mensajeSiNo(String mensaje) {
        Alert a = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.CLOSE);
        a.show();
        return a;
    }
    public static void lanzarErrorUsuario(String mensaje){
    Alert alert = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un error grave,\npongase en contacto con el suministrador de software:\n"
            + "Enigma Software S.L.N.E.\nCapture la pantalla con este error para informar al servicio técnico.\n"
            + "El error es este:\n"+mensaje, ButtonType.CLOSE);
    alert.show();
}
}
