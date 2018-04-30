package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorVentanaHuespedReserva implements Initializable {

    @FXML
    private Button botonAdd3, botonAdd1, botonAdd2, botonAdd4, botonAdd5, botonAdd6, botonOk,
            botonCancelar, botonBorrar1, botonBorrar2, botonBorrar3, botonBorrar4,
            botonBorrar5, botonBorrar6;

    @FXML
    public TextField TextFieldCliente, TextFieldReserva, TextFieldHuesped1,
            TextFieldHuesped2, TextFieldHuesped3, TextFieldHuesped4, TextFieldHuesped5,
            TextFieldHuesped6;

    public Reserva reserva = new Reserva();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonAdd1.setOnAction((e) -> {
            accionAdd1();
        });
        botonAdd2.setOnAction((e) -> {
            accionAdd2();
        });
        botonAdd3.setOnAction((e) -> {
            accionAdd3();
        });
        botonAdd4.setOnAction((e) -> {
            accionAdd4();
        });
        botonAdd5.setOnAction((e) -> {
            accionAdd5();
        });
        botonAdd6.setOnAction((e) -> {
            accionAdd6();
        });
        botonBorrar1.setOnAction((e) -> {
            accionBorrar1();
        });
        botonBorrar2.setOnAction((e) -> {
            accionBorrar2();
        });
        botonBorrar3.setOnAction((e) -> {
            accionBorrar3();
        });
        botonBorrar4.setOnAction((e) -> {
            accionBorrar4();
        });
        botonBorrar5.setOnAction((e) -> {
            accionBorrar5();
        });
        botonBorrar6.setOnAction((e) -> {
            accionBorrar6();
        });

        botonOk.setOnAction((e) -> {
            accionOK();
        });
        botonCancelar.setOnAction((e) -> {
            accionCancelar();
        });
        TextFieldCliente.setText(reserva.getNumero());
    }

    public TextField setReserva(Reserva r) {
        reserva = r;
        TextFieldCliente.setText(reserva.getNumero());
        return TextFieldCliente;
    }
/**
 * 
 */
    private void accionAdd1() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);
    }

    private void accionAdd2() {
        ObjetoVentana obj =VentanasFactory.getObjetoVentanaBuscarHuesped("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);

    }

    private void accionAdd3() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);

    }

    private void accionAdd4() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped ("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);

    }

    private void accionAdd5() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);

    }

    private void accionAdd6() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped("ventanaHuespedReserva", Modality.APPLICATION_MODAL,null);

    }

    private void accionBorrar1() {

    }

    private void accionBorrar2() {

    }

    private void accionBorrar3() {

    }

    private void accionBorrar4() {

    }

    private void accionBorrar5() {

    }

    private void accionBorrar6() {

    }

    private void accionOK() {

    }

    private void accionCancelar() {

    }
}
