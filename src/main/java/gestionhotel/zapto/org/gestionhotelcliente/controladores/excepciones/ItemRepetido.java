package gestionhotel.zapto.org.gestionhotelcliente.controladores.excepciones;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ItemRepetido extends Exception{
    String mensaje;
        public ItemRepetido(String mensaje) {
            this.mensaje=mensaje;
        }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
        
}
