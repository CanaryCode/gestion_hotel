package gestionhotel.zapto.org.gestionhotelcliente;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Ventanas.ventanaLogin=stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaLogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Log - in");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
