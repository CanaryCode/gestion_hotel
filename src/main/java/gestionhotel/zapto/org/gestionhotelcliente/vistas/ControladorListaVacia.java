package gestionhotel.zapto.org.gestionhotelcliente.vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorListaVacia implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    AnchorPane principal;
    @FXML
    TableView tabla;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public  void configuraTabla(ObservableList listaItems,
            ObservableList<CreadorDeTabla>listaCreadorDeTablas,String tituloVentana ){
        
        CreadorDeTabla.generaTabla(principal, tabla, listaItems, listaCreadorDeTablas);
        Platform.runLater(() -> {
            Ventanas.getVentana(Ventanas.LISTA_VACIA).setTitle(
                Ventanas.getVentana(Ventanas.LISTA_VACIA).getTitle()+" "+tituloVentana);
        });
        
    }
    
}
