package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import javafx.stage.Stage;


/**
 *Al extender de "Stage" se obtienen todas sus propiedades y se añaden dos 
 * variables mas que la del nombre y la de estar activa.
 * 
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class VentanaCustom extends Stage{
private String nombre, nombrePadre;
private boolean actividad;
private int modoDesvanecimiento;

/**
 * devuelve este tipo de objeto que no es que un "Stage" con las propiedades
 * de nombre y actividad.
 * 
 * @param nombre inicializa el nombre de la ventana.
 */
    public VentanaCustom(String nombre,String nombrePadre) {
        this.nombre = nombre;
    }

 /**
  * solo debería de utilizarse por el Objeto ventana el método configura ventana.
  * 
  * @param nombre configura el nombre de la ventana.
  */
    public void setMiNombre(String nombre) {
        this.nombre=nombre;
    }

 /**
  * se utiliza para saber que objeto ventana es exactamente.
  * 
  * @return nombre de la ventana
  */
    public String getMiNombre() {
        return nombre;
    }

 /**
  * comprueba si la ventana está activa.
  * 
  * @return si esta activa devuelve true sino, devuelve false.
  */
    public boolean isActiva() {
        return actividad;
    }

/**
 * modifica la propiedad de actividad y solamente se debería tocar por el objeto
 * ventana una vez que se ejecuta el método ver.
 * 
 * @param actividad configura que la propiedad actividad 
 */
    public void setActividad(boolean actividad) {
        this.actividad=actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public int getModoDesvanecimiento() {
        return modoDesvanecimiento;
    }

    public void setModoDesvanecimiento(int modoDesvanecimiento) {
        this.modoDesvanecimiento = modoDesvanecimiento;
    }
}
