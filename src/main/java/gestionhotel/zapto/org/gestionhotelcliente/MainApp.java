package gestionhotel.zapto.org.gestionhotelcliente;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new Ventanas().abrirVentanaPrincipal();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
