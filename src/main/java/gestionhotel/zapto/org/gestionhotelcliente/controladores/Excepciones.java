package gestionhotel.zapto.org.gestionhotelcliente.controladores;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Excepciones extends Exception {

    public static ItemRepetido getItemRepetido() {
        return new ItemRepetido();
    }
}

class ItemRepetido extends Exception {

}
