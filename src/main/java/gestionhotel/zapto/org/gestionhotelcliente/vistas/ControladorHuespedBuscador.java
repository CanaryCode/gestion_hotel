package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHuespedBuscador implements Initializable {

    @FXML
    private TextField nombre, primerApellido, segundoApellido, provincia, ciudad, calle,
            pasaporte, numero, codigoPostal, dni, telefonoFijo, telefonoMovil, correoElectronico;

    @FXML
    private DatePicker fechaNacimiento, fechaExpedicion;

    @FXML
    private RadioButton sexoM, sexoF, discapacitadoNo, discapacitadoSi;

    @FXML
    private ComboBox<?> nacionalidad, tratamiento, categoria;

    @FXML
    private Button borrar, crear, actualizar, seleccionar, aceptar;
    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido, toggleFnacimiento,
            toggleSexo, toggleDiscapacitado, toggleNacionalidad, toggleProvincia, toggleCiudad,
            toggleCalle, toggleNumero, toggleCodigoPostal, toggleDni, togglePasaporte,
            toggleExpPasaporte, toggleTelefonoFijo, toggleTelefonoMovil, toggleEmail, toggleTratamiento,
            toggleCategoría;

    @FXML
    private TableColumn<?, ?> tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada, tableColumnFechaPrevistaSalida, tableColumnHuesped;

    ObservableList<Persona> listaHuespedes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleNombre.setOnAction((e) -> {
            codigoToogleNombre();
        });
        togglePrimerApellido.setOnAction((e) -> {
            codigoTooglePrimerApellido();
        });
        toggleSegundoApellido.setOnAction((e) -> {
            codigoToogleSegundoApellido();
        });
        toggleFnacimiento.setOnAction((e) -> {
            codigoToogleFNacimiento();
        });
        toggleSexo.setOnAction((e) -> {
            codigoToogleSexo();
        });
        toggleDiscapacitado.setOnAction((e) -> {
            codigoToogleDiscapacitado();
        });
        toggleNacionalidad.setOnAction((e) -> {
            codigoToogleNacionalidad();
        });
        toggleProvincia.setOnAction((e) -> {
            codigoToogleProvincia();
        });
        toggleCiudad.setOnAction((e) -> {
            codigoToogleCiudad();
        });
        toggleCalle.setOnAction((e) -> {
            codigoToogleCalle();
        });
        toggleNumero.setOnAction((e) -> {
            codigoToogleNumero();
        });
        toggleCodigoPostal.setOnAction((e) -> {
            codigoToogleCodigoPostal();
        });
        toggleDni.setOnAction((e) -> {
            codigoToogleDni();
        });
        togglePasaporte.setOnAction((e) -> {
            codigoTooglePasaporte();
        });
        toggleExpPasaporte.setOnAction((e) -> {
            codigoToogleExpPasaporte();
        });
        toggleTelefonoFijo.setOnAction((e) -> {
            codigoToogleTelefonoFijo();
        });
        toggleTelefonoMovil.setOnAction((e) -> {
            codigoToogleTelefonoMovil();
        });
        toggleEmail.setOnAction((e) -> {
            codigoToogleEmail();
        });
        toggleTratamiento.setOnAction((e) -> {
            codigoToogleTratamiento();
        });
        toggleCategoría.setOnAction((e) -> {
            codigoToogleCategoria();
        });;

        borrar.setOnAction((e) -> {
            codigoBorrar();

        });

        crear.setOnAction((e) -> {
            codigoCrear();

        });
        actualizar.setOnAction((e) -> {
            codigoActualizar();
        });

        seleccionar.setOnAction((e) -> {
            codigoSeleccionar();

        });
        aceptar.setOnAction((e) -> {
            codigoAceptar();
        });
    }

    private void codigoToogleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
        } else {
            nombre.setDisable(true);
            nombre.setText("");
        }
    }

    private void codigoTooglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
        }
    }

    private void codigoToogleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
        }
    }

    private void codigoToogleFNacimiento() {
        if (toggleFnacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
        }
    }

    private void codigoToogleSexo() {
        if (toggleSexo.isSelected()) {
            sexoF.setDisable(false);
            sexoM.setDisable(false);
        } else {
            sexoF.setDisable(true);
            sexoM.setDisable(true);
            sexoM.setSelected(true);
        }
    }

    private void codigoToogleDiscapacitado() {
        if (toggleDiscapacitado.isSelected()) {
            discapacitadoNo.setDisable(false);
            discapacitadoSi.setDisable(false);
        } else {
            discapacitadoNo.setDisable(true);
            discapacitadoSi.setDisable(true);
            discapacitadoNo.setSelected(true);
        }
    }

    private void codigoToogleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
        }
    }

    private void codigoToogleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
        } else {
            provincia.setDisable(true);
            provincia.setText("");
        }
    }

    private void codigoToogleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
        }
    }

    private void codigoToogleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
        } else {
            calle.setDisable(true);
            calle.setText("");
        }
    }

    private void codigoToogleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
        } else {
            numero.setDisable(true);
            numero.setText("");
        }
    }

    private void codigoToogleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
        }
    }

    private void codigoToogleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
        } else {
            dni.setDisable(true);
            dni.setText("");
        }
    }

    private void codigoTooglePasaporte() {
        if (togglePasaporte.isSelected()) {
            pasaporte.setDisable(false);
        } else {
            pasaporte.setDisable(true);
            pasaporte.setText("");
        }
    }

    private void codigoToogleExpPasaporte() {
        if (toggleExpPasaporte.isSelected()) {
            fechaExpedicion.setDisable(false);
        } else {
            fechaExpedicion.setDisable(true);
            fechaExpedicion.setValue(null);
        }
    }

    private void codigoToogleTelefonoFijo() {
        if (toggleTelefonoFijo.isSelected()) {
            telefonoFijo.setDisable(false);
        } else {
            telefonoFijo.setDisable(true);
            telefonoFijo.setText("");
        }
    }

    private void codigoToogleTelefonoMovil() {
        if (toggleTelefonoMovil.isSelected()) {
            telefonoMovil.setDisable(false);
        } else {
            telefonoMovil.setDisable(true);
            telefonoMovil.setText("");
        }
    }

    private void codigoToogleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
        }
    }

    private void codigoToogleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
        }
    }

    private void codigoToogleCategoria() {
        if (toggleCategoría.isSelected()) {
            categoria.setDisable(false);
        } else {
            categoria.setDisable(true);
            categoria.getSelectionModel().selectFirst();
        }
    }

    private void codigoSeleccionar() {

    }

    private void codigoBorrar() {

    }

    private void codigoActualizar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuesped("ventanaHuespedBuscador", Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoCrear() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuesped("ventanaHuespedBuscador", Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoAceptar() {

    }

    public void setObjetos(ObservableList<Persona> listaPersonas) {
        this.listaHuespedes = listaPersonas;
    }
}
