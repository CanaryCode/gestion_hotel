package gestionhotel.zapto.org.gestionhotelcliente.modelos.BarraMenus;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Sistema;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorQuienesSomos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Barra {

    public static void creaBarra(MenuBar barra) {
        if (Sistema.getUsuarioSistema().getDepartamento().equals(Registro.ListaDeparmentos.get(1))) {
            barra.getMenus().addAll(Recepcion.getMenus());

        } else if (Sistema.getUsuarioSistema().getDepartamento().equals(Registro.ListaDeparmentos.get(2))) {

        }

        barra.getMenus().addAll(getMenusComunes());
    }

    private static ObservableList<Menu> getMenusComunes() {

        ObservableList<Menu> listaMenus = FXCollections.observableArrayList();

        MenuItem menuItemQuienesSomos = new MenuItem("Quienes somos");
        menuItemQuienesSomos.setOnAction((event) -> {
            Ventana vent = VentanasFactory.getQuienesSomos(Ventanas.PRINCIPAL, Modality.NONE, null);
            vent.verReajustable();
            ((ControladorQuienesSomos) vent.getfXMLLoader().getController()).reproduceVideo();
        });
        
        Menu MenuAcercaDe = new Menu("Acerca de");
        MenuAcercaDe.getItems().add(menuItemQuienesSomos);

        listaMenus.add(MenuAcercaDe);
        return listaMenus;
    }
}
