
package gestionhotel.zapto.org.gestionhotelcliente.controladores;
import java.awt.Toolkit;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class LimitadorDeCaracteres {
/**
 * 
 * @param tic Objeto al que se desea impletementar la restricción de caracteres.
 * Es la clase padre de los "textField y de los "textArea" por ejemplo.
 * @param limitacion la longitud máxima de la cadena de caracteres que se desea permitir.
 * 
 * añade una restricción de un máximo de caracteres a un "textField" o un "textArea" para
 * que no se pase del máximo limitado en la base de datos.
 */
    public static void addLimitacion(final TextInputControl tic,String nuevoValor,String ViejoValor, final int limitacion) {
            if (nuevoValor.length() > limitacion) {
                Toolkit.getDefaultToolkit().beep();
                tic.setText(ViejoValor);
            }
    }

}
