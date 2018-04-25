package gestionhotel.zapto.org.gestionhotelcliente;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.AbrirCerrarConexiones;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorClienteBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorFXMLLogIn;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AbrirCerrarConexiones.abrir();
        Ventanas.Objetos obj=new Ventanas().abrirVentanaLogIn();
        obj.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
