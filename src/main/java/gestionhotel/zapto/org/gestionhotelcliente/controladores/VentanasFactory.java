package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.stage.Modality;

/**
 *Factorias para abrir ventanas aqui esta toda la logica de configurar cada tipo de 
 * ventana en particular, es decir,  las especializaciones o caracteristicas propias
 * de cada ventana.
 * 
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class VentanasFactory {

    /**
     * abre la ventana de "Log-in". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     *
     * @return ventana preconfigurada lista para ver
     */
    public static ObjetoVentana getObjetoVentanaLogIn() {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("LogIn", Ventanas.LOGIN, null,
                ObjetoVentana.resourceBundle.getString("windows.logIn"), Modality.NONE, null,Ventanas.NO_DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     *
     * @return ventana preconfigurada lista para ver
     */
    public static ObjetoVentana getObjetoVentanaPrincipal() {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("Principal", Ventanas.PRINCIPAL,
                null, ObjetoVentana.resourceBundle.getString("windows.principal"), Modality.NONE, null,Ventanas.NO_DESVANECIBLE);
        return obj;

    }

    /**
     * abre la ventana "Huesped". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para ver
     */
    public static ObjetoVentana getObjetoVentanaHuespedFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("HuespedFormulario", Ventanas.HUESPED_FORMULARIO,
                owner, ObjetoVentana.resourceBundle.getString("windows.huesped"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana Reserva "Check-In". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir
     */
    public static ObjetoVentana getObjetoVentanaPrevision(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("Prevision", Ventanas.PREVISION,
                owner,"Prevision", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "quienes somos". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir
     */
    public static ObjetoVentana getObjetoVentanaQuienesSomos(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("QuienesSomos", Ventanas.QUIENES_SOMOS,
                owner, ObjetoVentana.resourceBundle.getString("windows.quienesSomos"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Registro Clientes". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaClienteFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("ClienteFormulario", Ventanas.CLIENTE_FORMULARIO,
                owner, ObjetoVentana.resourceBundle.getString("windows.cliente"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Reserva". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaReservaFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("ReservaFormulario", Ventanas.RESERVA_FORMULARIO,
                owner, ObjetoVentana.resourceBundle.getString("windows.addReserva"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Busca Huesped". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaBuscarHuesped(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("HuespedBuscador", Ventanas.HUESPED_BUSCADOR,
                owner, ObjetoVentana.resourceBundle.getString("windows.huespedBuscador"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Buscar Clientes". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaBuscarCliente(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("ClienteBuscador", Ventanas.CLIENTE_BUSCADOR,
                owner, ObjetoVentana.resourceBundle.getString("windows.clienteBuscador"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Calculadora". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaCalculadora(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("Calculadora", Ventanas.CALCULADORA,
                owner, ObjetoVentana.resourceBundle.getString("windows.calculadora"), modalidad, controlador,Ventanas.NO_DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana "Huesped Reserva". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaHuespedReserva(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("HuespedReserva", Ventanas.HUESPED_RESERVA,
                owner, ObjetoVentana.resourceBundle.getString("windows.HuespedReserva"), modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaTelefonoBuscador(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("TelefonoBuscador", Ventanas.TELEFONO_BUSCADOR,
                owner,"Buscador de teléfonos", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaTelefonoFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("TelefonoFormulario", Ventanas.TELEFONO_FORMULARIO,
                owner,"Teléfonos", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaReservaHabitacion(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("ReservaHabitacion", Ventanas.RESERVA_HABITACION,
                owner,"Reserva - Habitacion", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaCheckin(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("CheckIn", Ventanas.CHECK_IN,
                owner,"Check-In", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaDetallesReserva(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("AlojamientoFormulario", Ventanas.ALOJAMIENTO_FORMULARIO,
                owner,"Alojamiento", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaHabitacionFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("HabitacionFormulario", Ventanas.HABITACION_FORMULARIO,
                owner,"Formulario habitación", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
    /**
     * abre la ventana "Telefono buscador". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal, etc).
     * @param controlador controlador del fxml.
     * @return ventana preconfigurada lista para abrir.
     */
    public static ObjetoVentana getObjetoVentanaHabitacionBuscador(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("HabitacionBuscador", Ventanas.HABITACION_BUSCADOR,
                owner,"Buscador Habitación", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
}
