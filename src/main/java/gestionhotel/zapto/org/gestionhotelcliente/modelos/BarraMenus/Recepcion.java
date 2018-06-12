package gestionhotel.zapto.org.gestionhotelcliente.modelos.BarraMenus;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorListaVacia;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorPrevision;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Recepcion {

    public static ObservableList<Menu> getMenus() {

        ObservableList<Menu> listaMenus = FXCollections.observableArrayList();

        MenuItem menuItemPrevision = new MenuItem("Prevision");
        menuItemPrevision.setOnAction((event) -> {
            Ventana vent = VentanasFactory.getPrevision(Ventanas.PRINCIPAL, Modality.NONE, null);
            ((ControladorPrevision) vent.getfXMLLoader().getController()).
                    setFiltro(Select.getAlojamientosPendientesCheckIn());
            vent.verReajustable();
        });

        MenuItem menuItemListaHuespedesDentro = new MenuItem("Huéspedes Dentro");
        menuItemListaHuespedesDentro.setOnAction((event) -> {
            Ventana vent = VentanasFactory.getListaVacia(Ventanas.PRINCIPAL, Modality.NONE, null);
            ((ControladorListaVacia) vent.getfXMLLoader().getController()).
                    configuraTabla(new TablaHuesped().getListaObjetosDeTabla(Select.getHuespedesDentro()),
                    new TablaHuesped().getListaObjetosColumnas(), "Huéspedes dentro");
            vent.verReajustable();
        });
        
        MenuItem menuItemListaHabitacionesOcupadas = new MenuItem("Habitaciones ocupadas");
        menuItemListaHabitacionesOcupadas.setOnAction((event) -> {
            Ventana vent = VentanasFactory.getListaVacia(Ventanas.PRINCIPAL, Modality.NONE, null);
            ((ControladorListaVacia) vent.getfXMLLoader().getController()).
                    configuraTabla(new TablaHabitacion().getListaObjetosDeTabla(Select.getHabitacionesOcupadas()),
                    new TablaHabitacion().getListaObjetosColumnas(), "Habitaciones ocupadas");
            vent.verReajustable();
        });
        
        Menu menuListaHuesped = new Menu("Huéspedes");
        menuListaHuesped.getItems().addAll(menuItemListaHuespedesDentro);
        
        Menu menuListaHabitaciones = new Menu("Habitaciones");
        menuListaHabitaciones.getItems().addAll(menuItemListaHabitacionesOcupadas);
        
        Menu menuListas = new Menu("listas");
        menuListas.getItems().addAll(menuListaHuesped,menuListaHabitaciones);

        Menu menuRecepcion = new Menu("Recepción");
        menuRecepcion.getItems().addAll(menuItemPrevision, menuListas);

        listaMenus.addAll(menuRecepcion);
        return listaMenus;
    }
}
