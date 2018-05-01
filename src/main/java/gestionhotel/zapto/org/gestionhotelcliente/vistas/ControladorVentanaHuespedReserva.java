package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private Reserva reserva = new Reserva();
    ObservableList<Persona> listaHuespedes = FXCollections.observableArrayList();

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
        TextFieldHuesped1.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped1.getText().equals("")) {
                botonOk.setDisable(false);
                botonAdd2.setDisable(false);
            }else{
                botonBorrar2.setDisable(true);
               botonOk.setDisable(true); 
            }
        });
        TextFieldHuesped2.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped2.getText().equals("")) {
                botonAdd3.setDisable(false);
            }else{
                botonBorrar3.setDisable(true);
            }
        });
        TextFieldHuesped2.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped2.getText().equals("")) {
                botonAdd3.setDisable(false);
            }else{
                botonBorrar3.setDisable(true);
            }
        });
        TextFieldHuesped3.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped3.getText().equals("")) {
                botonAdd4.setDisable(false);
            }else{
                botonBorrar4.setDisable(true);
            }
        });
        TextFieldHuesped4.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped4.getText().equals("")) {
                botonAdd5.setDisable(false);
            }else{
                botonBorrar5.setDisable(true);
            }
        });
        TextFieldHuesped5.textProperty().addListener((observable) -> {
            if (!TextFieldHuesped5.getText().equals("")) {
                botonAdd6.setDisable(false);
            }else{
                botonBorrar6.setDisable(true);
            }
        });
    }

    public TextField setReserva(Reserva r) {
        reserva = r;
        TextFieldCliente.setText(reserva.getPersonaByCodCliente().getNombre() + " "
                + reserva.getPersonaByCodCliente().getFisPrimerApellido() + " "
                + reserva.getPersonaByCodCliente().getFisSegundoApellido());
        TextFieldReserva.setText(reserva.getNumero());
        return TextFieldCliente;
    }

    /**
     *
     */
    private void accionAdd1() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).setObjetos(listaHuespedes);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionAdd2() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionAdd3() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionAdd4() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionAdd5() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionAdd6() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
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
