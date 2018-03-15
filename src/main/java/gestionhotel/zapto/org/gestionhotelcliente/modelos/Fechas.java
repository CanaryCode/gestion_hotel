package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Fechas {
    LocalDateTime fechaActual;
    public Fechas() {
        fechaActual= LocalDateTime.now();
      
    }
    
    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }
    public String getTimeActual(){
        return fechaActual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
