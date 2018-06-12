package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.BarraMenus.Barra;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Fechas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Sistema;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.reloj.Reloj;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorPrincipal implements Initializable {
    
    @FXML
    private MenuBar barra;
    @FXML
    private Label nombreUsuario, pieDePágina, horaActual;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private HBox panelReloj;
    @FXML
    private Button botonCalculadora;
    @FXML
    private AnchorPane principal;

    private Fechas fechas;
    private Reloj reloj;
    private VBox relojArrancable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configuraNombreUsuario();
        configuraFotoUsuario();
        Barra.creaBarra(barra);
        
        botonCalculadora.setOnAction((e) -> {
            codigoAbrirCalculadora();
        });
     
        configuracionReloj();
    }

    private void configuracionReloj() {
        //configuración reloj
        fechas = new Fechas();
        reloj = new Reloj();
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                relojArrancable = reloj.getReloj();

            }
        });
        hilo.setPriority(Thread.MIN_PRIORITY);
        hilo.run();
        panelReloj.getChildren().add(relojArrancable);
        horaActual.setText(fechas.getTimeActual());
    }

    private void codigoAbrirCalculadora() {
        Ventana obj = VentanasFactory.getCalculadora(Ventanas.PRINCIPAL, Modality.NONE, null);
        if (obj != null && Ventanas.getVentana(obj.getNombreVentana()) == null) {
            obj.ver();
        }
    }

    private void configuraNombreUsuario() {
        String nombre = "", primerApellido = "", segundoApellido = "";
        if (Sistema.getUsuarioSistema().getPersona().getNombre() != null) {
            nombre = Sistema.getUsuarioSistema().getPersona().getNombre();
            if (Sistema.getUsuarioSistema().getPersona().getFisPrimerApellido() != null) {
                primerApellido = Sistema.getUsuarioSistema().getPersona().getFisPrimerApellido();
                if (Sistema.getUsuarioSistema().getPersona().getFisSegundoApellido() != null) {
                    segundoApellido = Sistema.getUsuarioSistema().getPersona().getFisSegundoApellido();
                }
                nombreUsuario.setText(nombre + " " + primerApellido + " " + segundoApellido);
            }
        } else {
            nombreUsuario.setText("Nombre usuario desconocido");
        }
    }

    private void configuraFotoUsuario() {
        byte[] b = Sistema.getUsuarioSistema().getPersona().getFoto();
        if (b != null) {
            imagenUsuario.setImage(new Image(new ByteArrayInputStream(b)));
        }
    }
   
}
