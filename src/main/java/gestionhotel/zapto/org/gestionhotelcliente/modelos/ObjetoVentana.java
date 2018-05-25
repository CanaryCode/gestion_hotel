package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.LanzadorDeError;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.util.Duration;

/**
 * Es una clase donde justamos varios objetos interesantes desde el cargador del
 * fxml,el "Stage" que en este caso es una especialización llamada
 * "ventanaCustom", la escena de este "stage", el controlador etc.
 *
 * este objeto es cargador por "VentanasFactory" y una vez configurado, pasado
 * hacia el sitio donde se solicite abrir la ventana, en ese momento ya estará
 * todo configurado para ver abrir la ventana que se hará con el método propio
 * ver(). Esto permite que si se desea añadir alguna configuración extra antes
 * de abrir se pueda hacer, por que una vez que se inicie el método ver() ya no
 * será posible.
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ObjetoVentana {

    /**
     * mapa de recursos de internacionalización.
     */
    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/mensajes");
    FXMLLoader fXMLLoader;
    VentanaCustom ventana;
    Scene scene;
    Parent parent;
    String nombreFXML, nombreVentana, titulo, ownerName;
    Modality modalidad;
    Object controlador;
    int modoDesvanecimiento;
    boolean cargado;

    /**
     *
     * @param fXMLLoader cargador del FXML
     * @param ventana Ventana que va a ha ser configurada.
     * @param owner nombre del padre de la ventana que va a ser modificada.
     * @param scene "Scene" en el que se cargará el "parent" resultante de la
     * carga del cargador de fxml.
     * @param parent objeto donde se cargará la carga del FXML.
     * @param nombreFXML nombre del FXML sin exteción ni ruta.
     * @param nombreVentana nombre que va a tener la ventana.
     * @param titulo titulo que va a tener la vantana cuando se este viendo.
     * @param modalidad modalidad con que se iniciará la ventana.
     * @param controlador controlador que se pudiera cargar al FXML
     * @param cargado propiedad que tendra la ventana.
     */
    public ObjetoVentana(FXMLLoader fXMLLoader, VentanaCustom ventana, String nombreFXML, String nombreVentana, String titulo, String ownerName, Modality modalidad, Object controlador, int modoDesvanecimiento, boolean cargado) {
        this.fXMLLoader = fXMLLoader;
        this.ventana = ventana;
        this.nombreFXML = nombreFXML;
        this.nombreVentana = nombreVentana;
        this.titulo = titulo;
        this.ownerName = ownerName;
        this.modalidad = modalidad;
        this.controlador = controlador;
        this.modoDesvanecimiento = modoDesvanecimiento;
        this.cargado = cargado;
    }

    public int getModoDesvanecimiento() {
        return modoDesvanecimiento;
    }

    public void setModoDesvanecimiento(int modoDesvanecimiento) {
        this.modoDesvanecimiento = modoDesvanecimiento;
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
     * Configura todas la propiedas que tiene el objeto. Como por ejemplo el
     * cargador del FXML que lo inicia y lo carga. Deja al objeto en un estado
     * listo para arrancar el método ver();
     *
     * @return
     */
    public ObjetoVentana configuraVentana() {
        try {
            ventana.setTitle(titulo);
            ventana.getIcons().add(new Image("/imagenes/hotel.png"));
            ventana.setMiNombre(nombreVentana);
            ventana.setModoDesvanecimiento(modoDesvanecimiento);
            fXMLLoader = new FXMLLoader(getClass().getResource("/fxml/" + nombreFXML + ".fxml"), resourceBundle);
            if (controlador != null) {
                fXMLLoader.setController(controlador);
            }
            ventana.setOnCloseRequest(Event -> {
                Event.consume();
                cerrar();
            });
            ventana.focusedProperty().addListener((observable) -> {
                if (ownerName != null) {
                    if (ventana.isFocused()) {
                        ventana.setOpacity(1);
                        if (Ventanas.getVentana(ownerName).getModoDesvanecimiento() == Ventanas.DESVANECIBLE) {
                            Ventanas.getVentana(ownerName).setOpacity(0.5);
                        }
                    }
                }
            });
            parent = getfXMLLoader().load();
            ventana.initModality(modalidad);
            VentanaCustom ventanaOwner = Ventanas.getVentana(ownerName);
            ventana.initOwner(ventanaOwner);
        } catch (Exception ex) {
            LanzadorDeError.lanzarErrorUsuario(ex.getMessage());
            Logger.getLogger(ObjetoVentana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ObjetoVentana();
    }

    /**
     * visualiza el "Stage" donde pueda ser redimensionado.
     */
    public void verReajustable() {
        VentanaCustom vc = Ventanas.getVentana(nombreVentana);
        if (vc == null || !vc.isActiva()) {
            scene = new Scene(parent);
            ventana.setScene(scene);
            ventana.show();
            efectoAbrirVentana();
            ventana.setActividad(true);
            Ventanas.addVentana(ventana);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "La ventana: " + titulo + "\n"
                    + "Está en uso, para abrir esta ventana tiene que cerrar la ventana en uso,\n"
                    + "Si cierra la ventana podrían perderse los cambios realizados.\n"
                    + "¿quiere cerrarla y abrirla de nuevo?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == ButtonType.YES) {
                Ventanas.cerrarVentana(ventana.getNombre());
                scene = new Scene(parent);
                ventana.setScene(scene);
                ventana.show();
                efectoAbrirVentana();
                ventana.setActividad(true);
                Ventanas.addVentana(ventana);
            }

        }
    }

    /**
     * visualiza el "Stage" donde no pueda ser redimensionado.
     */
    public void ver() {
        VentanaCustom vc = Ventanas.getVentana(nombreVentana);
        if (vc == null) {
            scene = new Scene(parent);
            ventana.setScene(scene);
            ventana.show();
            efectoAbrirVentana();
            ventana.setActividad(true);
            ventana.setResizable(false);
            Ventanas.addVentana(ventana);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "La ventana: " + titulo + "\n"
                    + "Está en uso, para abrir esta ventana tiene que cerrar la ventana en uso,\n"
                    + "Si cierra la ventana podrían perderse los cambios realizados.\n"
                    + "¿quiere cerrarla y abrirla de nuevo?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == ButtonType.YES) {
                Ventanas.cerrarVentana(ventana.getNombre());
                scene = new Scene(parent);
                ventana.setScene(scene);
                ventana.show();
                efectoAbrirVentana();
                ventana.setActividad(true);
                Ventanas.addVentana(ventana);
                ventana.setActividad(true);
                Ventanas.addVentana(ventana);
            }
        }
    }

    /**
     * cierra el "stage" y lo saca de la lista de ventanas activas.
     */
    public void cerrar() {
        this.ventana.setActividad(false);
        efectoCerrarVentana();
        Timeline tL = new Timeline(new KeyFrame(Duration.seconds(0.2), (event) -> {
            parent.setDisable(true);
            this.ventana.close();
            Ventanas.removeVentana(nombreVentana);
        }));
        tL.play();
    }

    private void efectoAbrirVentana() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), parent);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(1);
        //------------------------------------------------------------------------------------
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), parent);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        //---------------------------------------------------------------------------------------------
        scaleTransition.play();
        fadeTransition.play();
    }

    private void efectoCerrarVentana() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), parent);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        //------------------------------------------------------------------------------------
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), parent);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0);
        scaleTransition.setToY(0);
        scaleTransition.setCycleCount(1);
        //---------------------------------------------------------------------------------------------
        scaleTransition.play();
        fadeTransition.play();
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String owner) {
        this.ownerName = owner;
    }
}
