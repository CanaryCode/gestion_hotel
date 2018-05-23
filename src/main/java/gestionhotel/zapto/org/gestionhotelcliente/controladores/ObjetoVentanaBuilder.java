package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.VentanaCustom;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 * Aquí está toda la lógica sobre la construcción de un objeto ventana que es
 * común a todas las común a todas las ventanas.
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ObjetoVentanaBuilder {

    /**
     *
     * @param nombreFXML nombre del archivo "FXML" que se quiere abrir, sin la
     * extención ni la ruta.
     * @param NombreVentana nombre que tendra la ventana y que se añadira a la
     * ventana a la propiedad "miNombre".
     * @param NombreOwner nombre que tiene la ventana padre de la ventana que se
     * desea abrir.
     * @param titulo titulo que mostrará la ventana cuando se esté viendo.
     * @param modalidad modalidad de la ventana (Modal, normal, etc.).
     * @param controlador clase controladora que controlará el "FXML" se puede
     * dejar a null.
     * @return
     */
    public static ObjetoVentana crear(String nombreFXML, String NombreVentana, String NombreOwner,
            String titulo, Modality modalidad, Object controlador, int modoDesvanecimiento) {
        VentanaCustom vc = Ventanas.getVentana(NombreVentana);
        
            ObjetoVentana obj = new ObjetoVentana(
                    new FXMLLoader(), new VentanaCustom(NombreVentana, NombreOwner),nombreFXML, NombreVentana, titulo, NombreOwner, modalidad, null, modoDesvanecimiento, true);
           
            obj.configuraVentana();
            
            return obj;
    }
}
