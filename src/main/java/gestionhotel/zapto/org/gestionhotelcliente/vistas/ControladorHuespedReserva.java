package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHuespedReserva implements Initializable {

    @FXML
    private Button botonAddResponsable, botonBorrarResponsable, botonAddOtros, botonBorrarOtros,
            botonAddChild, botonBorrarChild, botonAddBebes, botonBorrarBebes,
            botonOk, reseteaCampos;

    @FXML
    private AnchorPane principal;
    @FXML
    private TableView<TablaHuesped> tablaResponsable, tablaOtros, tablaChild, tablaBebes;
    @FXML
    private TableColumn tableColumnNumeroResponsable, tableColumnDniResponsable, tableColumnNombreResponsable,
            tableColumnPrimerApellidoResponsable, tableColumnSegundoApellidoResponsable, tableColumnFechaNacimientoResponsable,
            tableColumnSexoResponsable, tableColumnDiscapacitadoResponsable, tableColumnCiudadResponsable, tableColumnProvinciaResponsable,
            tableColumnPaisResponsable, tableColumnCalleResponsable, tableColumnCodigoPostalResponsable,
            tableColumnPasaporteResponsable, tableColumnFechaExpedicionResponsable, tableColumnEmailResponsable,
            tableColumnTratamientoResponsable, tableColumnCategoriaResponsable,
            //------------------------------------------------------------------------------------------
            tableColumnNumeroOtros, tableColumnDniOtros, tableColumnNombreOtros, tableColumnPrimerApellidoOtros,
            tableColumnSegundoApellidoOtros, tableColumnFechaNacimientoOtros, tableColumnSexoOtros, tableColumnDiscapacitadoOtros,
            tableColumnCiudadOtros, tableColumnProvinciaOtros, tableColumnPaisOtros, tableColumnCalleOtros, tableColumnCodigoPostalOtros,
            tableColumnPasaporteOtros, tableColumnFechaExpedicionOtros, tableColumnEmailOtros, tableColumnTratamientoOtros,
            tableColumnCategoriaOtros,
            //-------------------------------------------------------------------------------------------
            tableColumnNumeroChild, tableColumnDniChild, tableColumnNombreChild, tableColumnPrimerApellidoChild,
            tableColumnSegundoApellidoChild, tableColumnFechaNacimientoChild, tableColumnSexoChild, tableColumnDiscapacitadoChild,
            tableColumnCiudadChild, tableColumnProvinciaChild, tableColumnPaisChild, tableColumnCalleChild, tableColumnCodigoPostalChild,
            tableColumnPasaporteChild, tableColumnFechaExpedicionChild, tableColumnEmailChild, tableColumnTratamientoChild,
            tableColumnCategoriaChild,
            //-------------------------------------------------------------------------------------------
            tableColumnNumeroBebes, tableColumnDniBebes, tableColumnNombreBebes, tableColumnPrimerApellidoBebes,
            tableColumnSegundoApellidoBebes, tableColumnFechaNacimientoBebes, tableColumnSexoBebes, tableColumnDiscapacitadoBebes,
            tableColumnCiudadBebes, tableColumnProvinciaBebes, tableColumnPaisBebes, tableColumnCalleBebes, tableColumnCodigoPostalBebes,
            tableColumnPasaporteBebes, tableColumnFechaExpedicionBebes, tableColumnEmailBebes, tableColumnTratamientoBebes,
            tableColumnCategoriaBebes;
    //-------------------------------------------------------------------------------------------

    private ObservableList<Persona> listaHuespedResponsable, listaHuespedOtros, listaHuespedChild, listaHuespedBebes, listaTodosLosHuespedes;
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable, listaTablaHuespedOtros, listaTablaHuespedChild, listaTablaHuespedBebes, listaTablaTodosLosHuespedes;
    private int maxHuespedResponsables = 1, maxHuespedOtros = 2, maxHuespedChild = 2, maxHuespedBebes;
    private Persona ResponsableEnVista, OtrosHuespedesEnVista, ChildEnVista, BebesEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonAddResponsable.setOnAction((e) -> {
            accionAddResponsable();
        });
        botonAddOtros.setOnAction((e) -> {
            accionAddOtros();
        });

        botonBorrarResponsable.setOnAction((e) -> {
            accionBorrarResponsable();
        });
        botonBorrarOtros.setOnAction((e) -> {
            accionBorrarOtros();
        });
        botonAddChild.setOnAction((e) -> {
            accionAddChild();
        });
        botonBorrarChild.setOnAction((e) -> {
            accionBorrarChild();
        });
        botonAddBebes.setOnAction((e) -> {
            accionAddBebes();
        });
        botonBorrarBebes.setOnAction((e) -> {
            accionBorrarBebes();
        });

        botonOk.setOnAction((e) -> {
            accionOK();
        });

        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        tableColumnDniOtros.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreOtros.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellidoOtros.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoOtros.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimientoOtros.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoOtros.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitadoOtros.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudadOtros.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaOtros.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPaisOtros.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleOtros.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalOtros.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporteOtros.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicionOtros.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmailOtros.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoOtros.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaOtros.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroOtros.setCellValueFactory(new PropertyValueFactory("numero"));
        //------------------------------------------------------------------------------------------
        tableColumnDniResponsable.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreResponsable.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellidoResponsable.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoResponsable.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimientoResponsable.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoResponsable.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitadoResponsable.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudadResponsable.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaResponsable.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPaisResponsable.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleResponsable.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalResponsable.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporteResponsable.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicionResponsable.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmailResponsable.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoResponsable.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaResponsable.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroResponsable.setCellValueFactory(new PropertyValueFactory("numero"));
        //------------------------------------------------------------------------------------------
        tableColumnDniChild.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreChild.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellidoChild.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoChild.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimientoChild.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoChild.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitadoChild.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudadChild.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaChild.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPaisChild.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleChild.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalChild.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporteChild.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicionChild.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmailChild.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoChild.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaChild.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroChild.setCellValueFactory(new PropertyValueFactory("numero"));
        //------------------------------------------------------------------------------------------
        tableColumnDniBebes.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreBebes.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellidoBebes.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoBebes.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimientoBebes.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoBebes.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitadoBebes.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudadBebes.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaBebes.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPaisBebes.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleBebes.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalBebes.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporteBebes.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicionBebes.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmailBebes.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoBebes.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaBebes.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroBebes.setCellValueFactory(new PropertyValueFactory("numero"));
        //------------------------------------------------------------------------------------------
        tablaResponsable.setOnMouseClicked((event) -> {
            ResponsableEnVista=UtilBuscador.onMouseClickedOnTable(tablaResponsable, event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ResponsableEnVista,
                    listaHuespedResponsable, botonBorrarResponsable);
        });
        tablaOtros.setOnMouseClicked((event) -> {
            OtrosHuespedesEnVista=UtilBuscador.onMouseClickedOnTable(tablaOtros, event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), OtrosHuespedesEnVista,
                    listaHuespedOtros, tablaOtros, botonBorrarOtros);
        });
        tablaChild.setOnMouseClicked((event) -> {
            ChildEnVista=UtilBuscador.onMouseClickedOnTable(tablaChild, event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ChildEnVista,
                    listaHuespedChild, botonBorrarChild);
        });
        tablaBebes.setOnMouseClicked((event) -> {
            UtilBuscador.onMouseClickedOnTable(tablaBebes, event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null),
                    BebesEnVista, listaHuespedBebes, botonBorrarBebes);
        });
    }

    private void accionAddResponsable() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA,
                Modality.WINDOW_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaHuespedResponsable).
                    setFiltro(PruebasModelo.getListaDeHuespedes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }

    }

    private void accionAddOtros() {

        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaHuespedOtros).
                    setFiltro(PruebasModelo.getListaDeHuespedes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }

    }

    private void accionAddChild() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaHuespedChild).
                    setFiltro(PruebasModelo.getListaDeHuespedes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void accionAddBebes() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaTodosLosHuespedes).
                    setFiltro(PruebasModelo.getListaDeHuespedes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void accionBorrarResponsable() {
        logicaBorrar(listaHuespedResponsable, tablaResponsable);

    }

    private void accionBorrarOtros() {
        logicaBorrar(listaHuespedOtros, tablaOtros);
    }

    private void accionBorrarChild() {
        logicaBorrar(listaHuespedChild, tablaChild);

    }

    private void accionBorrarBebes() {
        logicaBorrar(listaHuespedBebes, tablaBebes);
    }

    private void accionOK() {
        Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
    }

    private void codigoReseteaCampos() {
        listaHuespedOtros.clear();
        listaHuespedResponsable.clear();
        listaHuespedChild.clear();
        listaHuespedBebes.clear();
        listaTodosLosHuespedes.clear();
        listaTablaHuespedResponsable.clear();
        listaTablaHuespedOtros.clear();
        listaTablaHuespedChild.clear();
        listaTablaHuespedBebes.clear();
    }

    private void codigoAccionarBotonesBorrar(TableView tabla, Button boton) {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            boton.setDisable(false);
        } else {
            boton.setDisable(true);
        }
    }

    public ControladorHuespedReserva setNumeroHuespedes(int numeroResponsables, int numeroOtros,
            int numeroChild, int numeroBebes) {
        this.maxHuespedResponsables = numeroResponsables;
        this.maxHuespedOtros = numeroOtros;
        this.maxHuespedChild = numeroChild;
        this.maxHuespedBebes = numeroBebes;
        if (maxHuespedBebes > 0) {
            botonBorrarBebes.setDisable(false);
        }
        if (maxHuespedResponsables > 0) {
            botonAddResponsable.setDisable(false);
        }
        if (maxHuespedChild > 0) {
            botonAddChild.setDisable(false);
        }
        if (maxHuespedOtros > 0) {
            botonAddOtros.setDisable(false);
        }

        return this;
    }

    public ControladorHuespedReserva setListas(ObservableList<Persona> listaHuespedeOtros,
            ObservableList<Persona> listaHuespedResponsable, ObservableList<Persona> listaHuespedChild,
            ObservableList<Persona> listaHuespedBebes, ObservableList<Persona> listaTodosLosHuespedes, ObservableList<TablaHuesped> listaTablaHuespedResponsable,
            ObservableList<TablaHuesped> listaTablaHuespedOtros, ObservableList<TablaHuesped> listaTablaHuespedChild,
            ObservableList<TablaHuesped> listaTablaHuespedBebes, ObservableList<TablaHuesped> listaTablaTodosLosHuespedes) {

        this.listaHuespedOtros = listaHuespedeOtros;
        this.listaHuespedResponsable = listaHuespedResponsable;
        this.listaHuespedChild = listaHuespedChild;
        this.listaHuespedBebes = listaHuespedBebes;
        this.listaTodosLosHuespedes = listaTodosLosHuespedes;
        this.listaTablaHuespedResponsable = listaTablaHuespedResponsable;
        this.listaTablaHuespedOtros = listaTablaHuespedOtros;
        this.listaTablaHuespedChild = listaTablaHuespedChild;
        this.listaTablaHuespedBebes = listaTablaHuespedBebes;
        this.listaTablaTodosLosHuespedes = listaTablaTodosLosHuespedes;
        //-------------------------------------------------
        tablaResponsable.setItems(listaTablaHuespedResponsable);
        tablaOtros.setItems(listaTablaHuespedOtros);
        tablaChild.setItems(listaTablaHuespedChild);
        tablaBebes.setItems(listaTablaHuespedBebes);
        //-----------------------------------------------------------
        this.listaHuespedChild.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                cambioListas(cambio, listaHuespedChild, listaTablaHuespedChild);
                enciendoAdds(listaHuespedChild, maxHuespedChild, botonAddChild);
            }
        });
        this.listaHuespedBebes.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                cambioListas(cambio, listaHuespedBebes, listaTablaHuespedBebes);
                enciendoAdds(listaHuespedBebes, maxHuespedBebes, botonAddBebes);
            }
        });
        listaHuespedOtros.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                cambioListas(cambio, listaHuespedOtros, listaTablaHuespedOtros);
                enciendoAdds(listaHuespedOtros, maxHuespedOtros, botonAddOtros);
            }
        });
        listaHuespedResponsable.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                cambioListas(cambio, listaHuespedResponsable, listaTablaHuespedResponsable);
                enciendoAdds(listaHuespedResponsable, maxHuespedResponsables, botonAddResponsable);
            }
        });
        listaTodosLosHuespedes.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                if (listaTodosLosHuespedes.isEmpty()) {
                    reseteaCampos.setDisable(true);
                    botonOk.setDisable(true);
                } else {
                    reseteaCampos.setDisable(false);
                    botonOk.setDisable(false);
                }
            }
        });
        //----------------------------------------------------------------------------------------
        if (listaHuespedResponsable.isEmpty()) {
            botonBorrarResponsable.setDisable(true);
            reseteaCampos.setDisable(true);
            botonOk.setDisable(true);
        } else {
            botonBorrarResponsable.setDisable(false);
            reseteaCampos.setDisable(false);
            botonOk.setDisable(false);
        }
        if (listaHuespedOtros.isEmpty()) {
            botonBorrarOtros.setDisable(true);
        } else {
            botonBorrarOtros.setDisable(false);
        }
        if (listaHuespedChild.isEmpty()) {
            botonBorrarChild.setDisable(true);
        } else {
            botonBorrarChild.setDisable(false);
        }
        if (listaHuespedBebes.isEmpty()) {
            botonBorrarBebes.setDisable(true);
        } else {
            botonBorrarBebes.setDisable(false);
        }
        return this;
    }

    private void cambioListas(ListChangeListener.Change<? extends Persona> cambio, ObservableList<Persona> listaHuesped, ObservableList<TablaHuesped> listaTabla) {
        while (cambio.next()) {
            for (Persona p : cambio.getRemoved()) {
                listaTodosLosHuespedes.remove(p);
                listaTablaTodosLosHuespedes.clear();
                listaTablaTodosLosHuespedes.addAll(TablaHuesped.getTablaBuscadorHuesped(listaTodosLosHuespedes));
                listaTabla.addAll(TablaHuesped.getTablaBuscadorHuesped(listaHuesped));
            }
            for (Persona p : cambio.getAddedSubList()) {
                listaTodosLosHuespedes.add(p);
                listaTablaTodosLosHuespedes.clear();
                listaTablaTodosLosHuespedes.addAll(TablaHuesped.getTablaBuscadorHuesped(listaTodosLosHuespedes));
                listaTabla.addAll(TablaHuesped.getTablaBuscadorHuesped(listaHuesped));
            }
        }
    }

    private void logicaBorrar(ObservableList<Persona> listaHuesped, TableView<TablaHuesped> tabla) {
        for (Persona p : listaHuesped) {
            TablaHuesped th = tabla.getSelectionModel().getSelectedItem();
            if (th != null) {
                listaHuesped.remove(tabla.getSelectionModel().getSelectedIndex());
            }
        }
    }

    private void enciendoAdds(ObservableList<Persona> lista, int max, Button boton) {
        if (lista.size() < max) {
            boton.setDisable(false);
        } else {
            boton.setDisable(true);
        }
    }

    public void configuraVentana() {
        Ventanas.getVentana(Ventanas.HUESPED_RESERVA).setOnCloseRequest((event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Si sale de esta ventana se perderán toda la selección."
                    + "\n ¿Está de acuerdo con salir?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                borrarListas();
                Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
            } else {
                event.consume();
            }
        });
    }

    private void borrarListas() {
        listaHuespedBebes.clear();
        listaHuespedChild.clear();
        listaHuespedOtros.clear();
        listaHuespedResponsable.clear();
        listaTodosLosHuespedes.clear();
    }
}
