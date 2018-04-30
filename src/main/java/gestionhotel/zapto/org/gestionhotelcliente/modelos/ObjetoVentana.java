package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ObjetoVentana {

    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/mensajes");
    FXMLLoader fXMLLoader;
    VentanaCustom ventana, owner;
    Scene scene;
    Parent parent;
    String nombreFXML, nombreVentana, titulo;
    Modality modalidad;
    Object controlador;
    boolean cargado;

    public ObjetoVentana(FXMLLoader fXMLLoader, VentanaCustom ventana, VentanaCustom owner, Scene scene, Parent parent, String nombreFXML, String nombreVentana, String titulo, Modality modalidad, Object controlador, boolean cargado) {
        this.fXMLLoader = fXMLLoader;
        this.ventana = ventana;
        this.owner = owner;
        this.scene = scene;
        this.parent = parent;
        this.nombreFXML = nombreFXML;
        this.nombreVentana = nombreVentana;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.controlador = controlador;
        this.cargado = cargado;
    }

    public boolean isCargado() {
        return cargado;
    }

    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }

    public String getNombreVentana() {
        return nombreVentana;
    }

    public void setNombreVentana(String nombreVentana) {
        this.nombreVentana = nombreVentana;
    }

    /**
     * Configura los parámetros del "Stage".
     *
     * @param ventana ventana que se va a configurar.
     * @param owner ventana padre de la ventana que se va a configurar.
     * @param titulo Nombre de la ventana.
     * @param modalidad Tipo de modalidad (modal,normal).
     * @return stage ya configurado
     */
    public Stage configuraVentana() {
        try {
            ventana.setTitle(titulo);
            ventana.initModality(modalidad);
            ventana.getIcons().add(new Image("/imagenes/hotel.png"));
            ventana.setMiNombre(nombreVentana);
            fXMLLoader = new FXMLLoader(getClass().getResource("/fxml/" + nombreFXML + ".fxml"), resourceBundle);
            if(controlador!=null){
                fXMLLoader.setController(controlador);
            }
            ventana.setOnCloseRequest(Event -> {
                cerrar();
            });
            parent = getfXMLLoader().load();
            if (owner != null) {
                ventana.initOwner(owner);
            }
        } catch (IOException ex) {
            Logger.getLogger(ObjetoVentana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ventana;
    }

    public void verReajustable() {
        VentanaCustom vc = Ventanas.getVentana(nombreVentana);
        if (vc == null || !vc.isActiva()) {
            scene = new Scene(parent);
            ventana.setScene(scene);
            ventana.show();
            ventana.setActividad(true);
            Ventanas.addVentana(ventana);
        }
    }

    public void ver() {
        VentanaCustom vc = Ventanas.getVentana(nombreVentana);
        if (vc == null || !vc.isActiva()) {
            scene = new Scene(parent);
            ventana.setScene(scene);
            ventana.show();
            ventana.setActividad(true);
            ventana.setResizable(false);
            Ventanas.addVentana(ventana);
        }
    }

    public void cerrar() {
        Ventanas.removeVentana(nombreVentana);
        this.ventana.setActividad(false);
        this.ventana.close();
    }

    public String getNombreFXML() {
        return nombreFXML;
    }

    public void setNombreFXML(String nombreFXML) {
        this.nombreFXML = nombreFXML;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Object getControlador() {
        return controlador;
    }

    public void setControlador(Object controlador) {
        this.controlador = controlador;
    }

    public Modality getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modality modalidad) {
        this.modalidad = modalidad;
    }

    public VentanaCustom getVentana() {
        return ventana;
    }

    public void setVentana(VentanaCustom ventana) {
        this.ventana = ventana;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ObjetoVentana() {

    }

    public FXMLLoader getfXMLLoader() {
        return fXMLLoader;
    }

    public void setfXMLLoader(FXMLLoader fXMLLoader) {
        this.fXMLLoader = fXMLLoader;
    }

    public VentanaCustom getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = Ventanas.getVentana(owner);
    }
}
