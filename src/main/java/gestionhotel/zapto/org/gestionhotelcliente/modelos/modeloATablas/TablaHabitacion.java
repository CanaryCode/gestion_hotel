/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaHabitacion implements TablaInterface<TablaHabitacion, Habitacion> {

    String vista, numero, tipo, cama;

    public TablaHabitacion() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {

        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Número", "numero", 100));
        lista.add(new CreadorDeTabla("Vista", "vista", 300));
        lista.add(new CreadorDeTabla("Tipo", "tipo", 300));
        lista.add(new CreadorDeTabla("Cama", "cama", 100));

        return lista;
    }

    @Override
    public ObservableList<TablaHabitacion> getListaObjetosDeTabla(ObservableList<Habitacion> listaHabitacion) {
        ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
        if (!listaHabitacion.isEmpty()&&listaHabitacion!=null) {
            for (Habitacion habitacion : listaHabitacion) {
                String numero = String.valueOf(habitacion.getNumero());
                String vista = habitacion.getVistas();
               // String tipo = habitacion.getTipo();
                String cama = habitacion.getTipoCama();
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
