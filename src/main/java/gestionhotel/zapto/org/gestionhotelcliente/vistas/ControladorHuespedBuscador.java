package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
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
       aceptar.setOnAction((e)->{
           codigoAceptar();
       });
    }

    private void codigoToogleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
            toggleNombre.setText("1");
        } else {
            nombre.setDisable(true);
            nombre.setText("");
            toggleNombre.setText("0");
        }
    }

    private void codigoTooglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
            togglePrimerApellido.setText("1");
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
            togglePrimerApellido.setText("0");
        }
    }

    private void codigoToogleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
            toggleSegundoApellido.setText("1");
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
            toggleSegundoApellido.setText("0");
        }
    }

    private void codigoToogleFNacimiento() {
        if (toggleFnacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
            toggleFnacimiento.setText("1");
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
            toggleFnacimiento.setText("0");
        }
    }

    private void codigoToogleSexo() {
        if (toggleSexo.isSelected()) {
            sexoF.setDisable(false);
            sexoM.setDisable(false);
            togglePrimerApellido.setText("1");
        } else {
            sexoF.setDisable(true);
            sexoM.setDisable(true);
            sexoM.setSelected(true);
            toggleSexo.setText("0");
        }
    }

    private void codigoToogleDiscapacitado() {
        if (toggleDiscapacitado.isSelected()) {
            discapacitadoNo.setDisable(false);
            discapacitadoSi.setDisable(false);
            toggleDiscapacitado.setText("1");
        } else {
            discapacitadoNo.setDisable(true);
            discapacitadoSi.setDisable(true);
            discapacitadoNo.setSelected(true);
            toggleDiscapacitado.setText("0");
        }
    }

    private void codigoToogleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
            toggleNacionalidad.setText("1");
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
            toggleNacionalidad.setText("0");
        }
    }

    private void codigoToogleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
            toggleProvincia.setText("1");
        } else {
            provincia.setDisable(true);
            provincia.setText("");
            toggleProvincia.setText("0");
        }
    }

    private void codigoToogleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
            toggleCiudad.setText("1");
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
            toggleCiudad.setText("0");
        }
    }

    private void codigoToogleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
            toggleCalle.setText("1");
        } else {
            calle.setDisable(true);
            calle.setText("");
            toggleCalle.setText("0");
        }
    }

    private void codigoToogleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
            toggleNumero.setText("1");
        } else {
            numero.setDisable(true);
            numero.setText("");
            toggleNumero.setText("0");
        }
    }

    private void codigoToogleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
            toggleCodigoPostal.setText("1");
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
            toggleCodigoPostal.setText("0");
        }
    }

    private void codigoToogleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
            toggleDni.setText("1");
        } else {
            dni.setDisable(true);
            dni.setText("");
            toggleDni.setText("0");
        }
    }

    private void codigoTooglePasaporte() {
        if (togglePasaporte.isSelected()) {
            pasaporte.setDisable(false);
            togglePasaporte.setText("1");
        } else {
            pasaporte.setDisable(true);
            pasaporte.setText("");
            togglePasaporte.setText("0");
        }
    }

    private void codigoToogleExpPasaporte() {
        if (toggleExpPasaporte.isSelected()) {
            fechaExpedicion.setDisable(false);
            toggleExpPasaporte.setText("1");
        } else {
            fechaExpedicion.setDisable(true);
            fechaExpedicion.setValue(null);
            toggleExpPasaporte.setText("0");
        }
    }

    private void codigoToogleTelefonoFijo() {
        if (toggleTelefonoFijo.isSelected()) {
            telefonoFijo.setDisable(false);
            toggleTelefonoFijo.setText("1");
        } else {
            telefonoFijo.setDisable(true);
            telefonoFijo.setText("");
            toggleTelefonoFijo.setText("0");
        }
    }

    private void codigoToogleTelefonoMovil() {
        if (toggleTelefonoMovil.isSelected()) {
            telefonoMovil.setDisable(false);
            toggleTelefonoMovil.setText("1");
        } else {
            telefonoMovil.setDisable(true);
            telefonoMovil.setText("");
            toggleTelefonoMovil.setText("0");
        }
    }

    private void codigoToogleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
            toggleEmail.setText("1");
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
            toggleEmail.setText("0");
        }
    }

    private void codigoToogleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
            toggleTratamiento.setText("1");
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
            toggleTratamiento.setText("0");
        }
    }

    private void codigoToogleCategoria() {
        if (toggleCategoría.isSelected()) {
            categoria.setDisable(false);
            toggleCategoría.setText("1");
        } else {
            categoria.setDisable(true);
            categoria.getSelectionModel().selectFirst();
            toggleCategoría.setText("0");
        }
    }

    private void codigoSeleccionar() {

    }

    private void codigoBorrar() {

    }

    private void codigoActualizar() {
         new Ventanas().abrirVentanaHuesped(Ventanas.ventanaHuespedBuscador, Modality.APPLICATION_MODAL);
    }

    private void codigoCrear() {
        new Ventanas().abrirVentanaHuesped(Ventanas.ventanaHuespedBuscador, Modality.APPLICATION_MODAL);
    }
    private void codigoAceptar() {
        
    }
}
