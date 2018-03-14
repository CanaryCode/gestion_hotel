package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import com.sun.xml.internal.ws.resources.ProviderApiMessages;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.util.Locale;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ConfiguradorIdioma {

    public static Locale cambiaIdioma(String idioma) {
        try {
            switch (idioma) {
                case "Español": {
                    return Locale.forLanguageTag("es");
                }
                case "English": {
                    return Locale.forLanguageTag("en");
                }
                default: {
                    return null;
                }
            }
        } catch (Exception e) {

        }
          return Locale.getDefault();
    }

}
