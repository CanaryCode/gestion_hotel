package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorVentanaHuespedReserva implements Initializable {

    @FXML
    private Button botonAdd3, botonAdd1, botonAdd2, botonAdd4, botonAdd5, botonAdd6, botonOk,
            botonBorrar1, botonBorrar2, botonBorrar3, botonBorrar4,
            botonBorrar5, botonBorrar6, reseteaCampos;

    @FXML
    public TextField TextFieldCliente, TextFieldReserva, TextFieldHuesped1,
            TextFieldHuesped2, TextFieldHuesped3, TextFieldHuesped4, TextFieldHuesped5,
            TextFieldHuesped6;
    @FXML
    public AnchorPane principal;

    private DetallesReserva detalleReserva = new DetallesReserva();
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
        TextFieldCliente.setText(detalleReserva.getNombreReserva());
        TextFieldHuesped1.textProperty().addListener((observable) -> {
            codigoTextFieldHuesped1();
        });
        TextFieldHuesped2.textProperty().addListener((observable) -> {
            codigoTextFieldHuesped2();
        });
        TextFieldHuesped3.textProperty().addListener((observable) -> {
            codigoTextFieldHuesped3();
        });
        TextFieldHuesped4.textProperty().addListener((observable) -> {
            codigoTextFieldHuesped4();
        });
        TextFieldHuesped5.textProperty().addListener((observable) -> {
          codigoTextFieldHuesped5();
        });
       reseteaCampos.setOnAction((event) -> {
           codigoReseteaCampos();
       });
    }

    public TextField setReserva(DetallesReserva r) {
        detalleReserva = r;
//        TextFieldCliente.setText(reserva.getPersonaByCodCliente().getNombre() + " "
//                + reserva.getPersonaByCodCliente().getFisPrimerApellido() + " "
//                + reserva.getPersonaByCodCliente().getFisSegundoApellido());
        TextFieldReserva.setText(detalleReserva.getNombreReserva());
        return TextFieldCliente;
    }

    /**
     *
     */
    private void accionAdd1() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
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

    private void codigoTextFieldHuesped1() {
        if (!TextFieldHuesped1.getText().equals("")) {
            botonBorrar2.setDisable(false);
            botonAdd2.setDisable(false);
        } else {
            botonBorrar2.setDisable(true);
            botonBorrar2.setDisable(true);
        }
    }

    private void codigoTextFieldHuesped2() {
        if (!TextFieldHuesped2.getText().equals("")) {
            botonAdd3.setDisable(false);
            botonBorrar3.setDisable(false);
        } else {
            botonBorrar3.setDisable(true);
            botonBorrar3.setDisable(true);
        }
    }

    private void codigoTextFieldHuesped3() {
        if (!TextFieldHuesped3.getText().equals("")) {
            botonAdd4.setDisable(false);
            botonBorrar4.setDisable(false);
        } else {
            botonBorrar4.setDisable(true);
            botonBorrar4.setDisable(true);
        }
    }

    private void codigoTextFieldHuesped4() {
        if (!TextFieldHuesped4.getText().equals("")) {
            botonAdd5.setDisable(false);
            botonBorrar5.setDisable(false);
        } else {
            botonBorrar5.setDisable(true);
            botonBorrar5.setDisable(true);
        }
    }

    private void codigoTextFieldHuesped5() {
  if (!TextFieldHuesped5.getText().equals("")) {
                botonAdd6.setDisable(false);
                botonBorrar6.setDisable(false);
            } else {
                botonBorrar6.setDisable(true);
                botonBorrar6.setDisable(true);
            }
    }
private void codigoReseteaCampos(){
    RecorredorPaneles.reseteaControles(principal);
    listaHuespedes.removeAll(listaHuespedes);
    TextFieldReserva.setText(detalleReserva.getNombreReserva());
}
   
}
