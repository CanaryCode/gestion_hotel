package gestionhotel.zapto.org.gestionhotelcliente;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.AbrirCerrarConexiones;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AbrirCerrarConexiones.abrir();
        ObjetoVentana obj=VentanasFactory.getObjetoVentanaLogIn();
          if (obj != null) {
                obj.ver();
          }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
