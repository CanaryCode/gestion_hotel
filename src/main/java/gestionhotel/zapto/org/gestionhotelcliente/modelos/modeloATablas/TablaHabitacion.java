/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaHabitacion {

    String vista, numero, tipo, cama;

    public static ObservableList<TablaHabitacion> getTablaHabitacion(ObservableList<Habitacion> listaHabitacion) {
        ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
        if (!listaHabitacion.isEmpty()) {
            for (Habitacion habitacion : listaHabitacion) {
                String numero = String.valueOf(habitacion.getNumero());
                String vista = habitacion.getDescripcion();
                String tipo = habitacion.getTipo();
                String cama = "";
                TablaHabitacion tH = new TablaHabitacion(vista, numero, tipo, cama);
                
                listaTablaHabitacion.add(tH);
            }
        }
        return listaTablaHabitacion;
    }

    public TablaHabitacion(String vista, String numero, String tipo, String cama) {
        this.vista = vista;
        this.numero = numero;
        this.tipo = tipo;
        this.cama = cama;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }

}
