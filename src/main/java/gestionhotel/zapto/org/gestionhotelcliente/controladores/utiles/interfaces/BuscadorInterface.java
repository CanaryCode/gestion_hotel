/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces;

import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public interface BuscadorInterface {
    public BuscadorInterface setModo(int modo);
    public <T> BuscadorInterface setListaToAdd(ObservableList<T> ListaObjeto);
    public <T> BuscadorInterface setFiltro(ObservableList<T> ListaObjeto);
}
