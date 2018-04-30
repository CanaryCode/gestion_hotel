package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
            toggleNombre.setText("1");
        } else {
            nombre.setDisable(true);
            nombre.setText("");
            toggleNombre.setText("0");
        }
        activarBotonBuscar(panelFiltro, buscar);
    }

    private void codigoTogglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
            togglePrimerApellido.setText("1");
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
            togglePrimerApellido.setText("0");
        }
    }

    private void codigoToggleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
            toggleSegundoApellido.setText("1");
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
            toggleSegundoApellido.setText("0");
        }
    }

    private void codigoToggleFNacimiento() {
        if (toggleFNacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
            toggleFNacimiento.setText("1");
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
            toggleFNacimiento.setText("0");
        }
    }

    private void codigoToggleCif() {
        if (toogleCif.isSelected()) {
            cif.setDisable(false);
            toogleCif.setText("1");
        } else {
            cif.setDisable(true);
            cif.setText("");
            toogleCif.setText("0");
        }
    }

    private void codigoToggleNombreEmpresa() {
        if (toggleNombreEmpresa.isSelected()) {
            nombreEmpresa.setDisable(false);
            toggleNombreEmpresa.setText("1");
        } else {
            nombreEmpresa.setDisable(true);
            nombreEmpresa.setText("");
            toggleNombreEmpresa.setText("0");
        }
    }

    private void codigoToggleRazonSocial() {
        if (toggleRazonSocial.isSelected()) {
            razonSocial.setDisable(false);
            toggleRazonSocial.setText("1");
        } else {
            razonSocial.setDisable(true);
            razonSocial.getSelectionModel().selectFirst();
            toggleRazonSocial.setText("0");
        }
    }

    private void codigoToggleSexo() {
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

    private void codigoToggleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
            toggleNacionalidad.setText("1");
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
            toggleNacionalidad.setText("0");
        }
    }

    private void codigoToggleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
            toggleTratamiento.setText("1");
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
            toggleTratamiento.setText("0");
        }
    }

    private void codigoToggleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
            toggleDni.setText("1");
        } else {
            dni.setDisable(true);
            dni.setText("");
            toggleDni.setText("0");
        }
    }

    private void codigoToggleEstado() {
        if (toggleEstado.isSelected()) {
            estado.setDisable(false);
            toggleEstado.setText("1");
        } else {
            estado.setDisable(true);
            estado.getSelectionModel().selectFirst();
            toggleDni.setText("0");
        }
    }

    private void codigoToggleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
            toggleProvincia.setText("1");
        } else {
            provincia.setDisable(true);
            provincia.setText("");
            toggleProvincia.setText("0");
        }
    }

    private void codigoToggleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
            toggleCiudad.setText("1");
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
            toggleCiudad.setText("0");
        }
    }

    private void codigoToggleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
            toggleCalle.setText("1");
        } else {
            calle.setDisable(true);
            calle.setText("");
            toggleCalle.setText("0");
        }
    }

    private void codigoToggleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
            toggleNumero.setText("1");
        } else {
            numero.setDisable(true);
            numero.setText("");
            toggleNumero.setText("0");
        }
    }

    private void codigoToggleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
            toggleCodigoPostal.setText("1");
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
            toggleCodigoPostal.setText("0");
        }
    }

    private void codigoToggleTelefonoFijo() {
        if (toggleTelefonoFijo.isSelected()) {
            telefonoFijo.setDisable(false);
            toggleTelefonoFijo.setText("1");
        } else {
            telefonoFijo.setDisable(true);
            telefonoFijo.setText("");
            toggleTelefonoFijo.setText("0");
        }
    }

    private void codigoToggleTelefonoMovil() {
        if (toggleTelefonoMovil.isSelected()) {
            telefonoMovil.setDisable(false);
            toggleTelefonoMovil.setText("1");
        } else {
            telefonoMovil.setDisable(true);
            telefonoMovil.setText("");
            toggleTelefonoMovil.setText("0");
        }
    }

    private void codigoToggleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
            toggleEmail.setText("1");
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
            toggleEmail.setText("0");
        }
    }

    private void codigoToggleCategoria() {
        if (toggleCategoria.isSelected()) {
            categoria.setDisable(false);
            toggleCategoria.setText("1");
        } else {
            categoria.setDisable(true);
            categoria.getSelectionModel().selectFirst();
            toggleCategoria.setText("0");
        }
    }

    private void codigoSeleccionar() {

    }

    private void codigoBorrar() {

    }

    private void codigoActualizar() {
        VentanasFactory.getObjetoVentanaRegistroClientes("ventanaHuespedBuscador", Modality.APPLICATION_MODAL,null);
    }

    private void codigoCrear() {
       VentanasFactory.getObjetoVentanaRegistroClientes("ventanaHuespedBuscador", Modality.APPLICATION_MODAL,null);
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
