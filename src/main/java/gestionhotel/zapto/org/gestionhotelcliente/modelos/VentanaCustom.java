package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import javafx.stage.Stage;


/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class VentanaCustom extends Stage{
String nombre;
boolean actividad;

    public VentanaCustom(String nombre) {
        this.nombre = nombre;
    }

 
    public void setMiNombre(String nombre) {
        this.nombre=nombre;
    }

 
    public String getMiNombre() {
        return nombre;
    }

 
    public boolean isActiva() {
        return actividad;
    }


    public void setActividad(boolean actividad) {
        this.actividad=actividad;
    }
}
