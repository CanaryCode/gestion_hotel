package gestionhotel.zapto.org.gestionhotelcliente;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.Conexiones;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Sistema;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Sistema.setHostServicesDelegate(HostServicesFactory.getInstance(this));
        ObjetoVentana obj=VentanasFactory.getLogIn();
          if (obj != null) {
                obj.ver();
          }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
