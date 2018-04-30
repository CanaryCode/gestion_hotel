package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.VentanaCustom;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ObjetoVentanaBuilder {

    public static ObjetoVentana crear(String nombreFXML, String NombreVentana, String NombreOwner,
            String titulo, Modality modalidad, Object controlador) {
        
        VentanaCustom vc = Ventanas.getVentana(NombreVentana);
        if (vc == null || !vc.isActiva()) {
           ObjetoVentana obj=new ObjetoVentana(new FXMLLoader(), new VentanaCustom(NombreVentana),
                   NombreOwner, null,null, 
                   nombreFXML, NombreVentana, titulo, modalidad, null, false);
           obj.configuraVentana();
            return obj;
        }
        return null;
    }
}
