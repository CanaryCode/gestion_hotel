
package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.util.Locale;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Lenguaje {
   
    public static void cambiaIdioma(String idioma){
        switch (idioma){
            case "Español":{
            Locale.setDefault(Locale.forLanguageTag("es"));
            }
            case "English":{
             Locale.setDefault(Locale.forLanguageTag("en"));
            }
        }

    }
    
}
