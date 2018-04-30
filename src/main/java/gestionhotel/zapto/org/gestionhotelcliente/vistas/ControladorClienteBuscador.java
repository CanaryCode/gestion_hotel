package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorClienteBuscador implements Initializable {

    @FXML
    private Tab tabPersona, tabEmpresa;
    @FXML
    private TextField nombre, primerApellido, segundoApellido, dni, nombreEmpresa,
            cif, provincia, ciudad, calle, numero, codigoPostal, telefonoFijo, telefonoMovil,
            correoElectronico;
    @FXML
    private DatePicker fechaNacimiento;
    @FXML
    private RadioButton sexoM, sexoF;
    @FXML
    private ComboBox<?> nacionalidad, tratamiento, categoria, razonSocial, estado;
    @FXML
    private Button borrar, crear, actualizar, buscar;
    @FXML
    private TableColumn<?, ?> FtableColumnNumeroReserva, tableColumnCliente,
            tableColumnHabitacion, tableColumnTipoHabitacion, tableColumnFechaPrevistaEntrada,
            tableColumnFechaPrevistaSalida, tableColumnHuesped;
    @FXML
    AnchorPane panelPersona, panelEmpresa, panelFiltro;

    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido,
            toggleFNacimiento, toogleCif, toggleNombreEmpresa, toggleRazonSocial, toggleSexo,
            toggleNacionalidad, toggleTratamiento, toggleDni, toggleEstado, toggleProvincia,
            toggleCiudad, toggleCalle, toggleNumero, toggleCodigoPostal,
            toggleTelefonoFijo, toggleTelefonoMovil, toggleEmail, toggleCategoria;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleNombre.setOnAction((e) -> {
            codigoToggleNombre();
        });
        togglePrimerApellido.setOnAction((e) -> {
            codigoTogglePrimerApellido();
        });
        toggleSegundoApellido.setOnAction((e) -> {
            codigoToggleSegundoApellido();
        });
        toggleFNacimiento.setOnAction((e) -> {
            codigoToggleFNacimiento();
        });
        toogleCif.setOnAction((e) -> {
            codigoToggleCif();
        });
        toggleNombreEmpresa.setOnAction((e) -> {
            codigoToggleNombreEmpresa();
        });
        toggleRazonSocial.setOnAction((e) -> {
            codigoToggleRazonSocial();
        });
        toggleNacionalidad.setOnAction((e) -> {
            codigoToggleNacionalidad();
        });
        toggleTratamiento.setOnAction((e) -> {
            codigoToggleTratamiento();
        });
        toggleDni.setOnAction((e) -> {
            codigoToggleDni();
        });
        toggleEstado.setOnAction((e) -> {
            codigoToggleEstado();
        });
        toggleProvincia.setOnAction((e) -> {
            codigoToggleProvincia();
        });
        toggleCiudad.setOnAction((e) -> {
            codigoToggleCiudad();
        });
        toggleCalle.setOnAction((e) -> {
            codigoToggleCalle();
        });
        toggleNumero.setOnAction((e) -> {
            codigoToggleNumero();
        });
        toggleCodigoPostal.setOnAction((e) -> {
            codigoToggleCodigoPostal();
        });
        toggleTelefonoFijo.setOnAction((e) -> {
            codigoToggleTelefonoFijo();
        });
        toggleTelefonoMovil.setOnAction((e) -> {
            codigoToggleTelefonoMovil();
        });
        toggleEmail.setOnAction((e) -> {
            codigoToggleEmail();
        });
        toggleCategoria.setOnAction((e) -> {
            codigoToggleCategoria();
        });
        toggleSexo.setOnAction((e) -> {
            codigoToggleSexo();
        });

        borrar.setOnAction((e) -> {
            codigoBorrar();
            {

            }
        });

        crear.setOnAction((e) -> {
            codigoCrear();
            {

            }
        });
        actualizar.setOnAction((e) -> {
            codigoActualizar();
            {

            }
        });
        buscar.setOnAction((e) -> {
            codigoSeleccionar();
            {

            }
        });

    }

    private void codigoToggleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
        } else {
            nombre.setDisable(true);
            nombre.setText("");
        }
        activarBotonBuscar(panelFiltro, buscar);
    }

    private void codigoTogglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
        }
    }

    private void codigoToggleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
        }
    }

    private void codigoToggleFNacimiento() {
        if (toggleFNacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
        }
    }

    private void codigoToggleCif() {
        if (toogleCif.isSelected()) {
            cif.setDisable(false);
        } else {
            cif.setDisable(true);
            cif.setText("");
        }
    }

    private void codigoToggleNombreEmpresa() {
        if (toggleNombreEmpresa.isSelected()) {
            nombreEmpresa.setDisable(false);
        } else {
            nombreEmpresa.setDisable(true);
            nombreEmpresa.setText("");
        }
    }

    private void codigoToggleRazonSocial() {
        if (toggleRazonSocial.isSelected()) {
            razonSocial.setDisable(false);
        } else {
            razonSocial.setDisable(true);
            razonSocial.getSelectionModel().selectFirst();
        }
    }

    private void codigoToggleSexo() {
        if (toggleSexo.isSelected()) {
            sexoF.setDisable(false);
            sexoM.setDisable(false);
        } else {
            sexoF.setDisable(true);
            sexoM.setDisable(true);
            sexoM.setSelected(true);
        }
    }

    private void codigoToggleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
        }
    }

    private void codigoToggleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
        }
    }

    private void codigoToggleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
        } else {
            dni.setDisable(true);
            dni.setText("");
        }
    }

    private void codigoToggleEstado() {
        if (toggleEstado.isSelected()) {
            estado.setDisable(false);
        } else {
            estado.setDisable(true);
            estado.getSelectionModel().selectFirst();
        }
    }

    private void codigoToggleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
        } else {
            provincia.setDisable(true);
            provincia.setText("");
        }
    }

    private void codigoToggleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
        }
    }

    private void codigoToggleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
        } else {
            calle.setDisable(true);
            calle.setText("");
        }
    }

    private void codigoToggleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
        } else {
            numero.setDisable(true);
            numero.setText("");
        }
    }

    private void codigoToggleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
        }
    }

    private void codigoToggleTelefonoFijo() {
        if (toggleTelefonoFijo.isSelected()) {
            telefonoFijo.setDisable(false);
        } else {
            telefonoFijo.setDisable(true);
            telefonoFijo.setText("");
        }
    }

    private void codigoToggleTelefonoMovil() {
        if (toggleTelefonoMovil.isSelected()) {
            telefonoMovil.setDisable(false);
        } else {
            telefonoMovil.setDisable(true);
            telefonoMovil.setText("");;
        }
    }

    private void codigoToggleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
        }
    }

    private void codigoToggleCategoria() {
        if (toggleCategoria.isSelected()) {
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
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaRegistroClientes("ventanaHuespedBuscador", Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoCrear() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaRegistroClientes("ventanaHuespedBuscador", Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void activarBotonBuscar(Pane pane, Control... control) {
        //inicializo la variable
        boolean hayConsulta = false;
        List<ToggleButton> lista = RecorredorPaneles.recorrePanelesToggle(pane, new ArrayList<>());
        for (ToggleButton toggleButton : lista) {

            if (toggleButton.isSelected()) {
                hayConsulta = true;
                break;
            }
        }
        if (hayConsulta == true) {
            for (Control c : control) {
                c.setDisable(false);
            }
        } else {
            for (Control c : control) {
                c.setDisable(true);
            }
        }
    }

}
