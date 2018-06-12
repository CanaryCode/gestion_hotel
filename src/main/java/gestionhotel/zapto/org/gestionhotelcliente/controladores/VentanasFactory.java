package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
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
    public static Ventana getLogIn() {
        Ventana obj = Ventana.crear("LogIn", Ventanas.LOGIN, null,
                Ventana.resourceBundle.getString("windows.logIn"), Modality.NONE, null,Ventanas.NO_DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     *
     * @return ventana preconfigurada lista para ver
     */
    public static Ventana getPrincipal() {
        Ventana obj = Ventana.crear("Principal", Ventanas.PRINCIPAL,
                null, Ventana.resourceBundle.getString("windows.principal"), Modality.NONE, null,Ventanas.NO_DESVANECIBLE);
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
    public static Ventana getHuespedFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("HuespedFormulario", Ventanas.HUESPED_FORMULARIO,
                owner, "Formulario huésped", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getPrevision(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("Prevision", Ventanas.PREVISION,
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
    public static Ventana getQuienesSomos(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("QuienesSomos", Ventanas.QUIENES_SOMOS,
                owner, Ventana.resourceBundle.getString("windows.quienesSomos"), modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getClienteFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("ClienteFormulario", Ventanas.CLIENTE_FORMULARIO,
                owner, "Formulario cliente", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getReservaFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("ReservaFormulario", Ventanas.RESERVA_FORMULARIO,
                owner,"Formulario reserva", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getBuscarHuesped(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("HuespedBuscador", Ventanas.HUESPED_BUSCADOR,
                owner, Ventana.resourceBundle.getString("windows.huespedBuscador"), modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getBuscarCliente(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("ClienteBuscador", Ventanas.CLIENTE_BUSCADOR,
                owner, Ventana.resourceBundle.getString("windows.clienteBuscador"), modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getCalculadora(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("Calculadora", Ventanas.CALCULADORA,
                owner, Ventana.resourceBundle.getString("windows.calculadora"), modalidad, controlador,Ventanas.NO_DESVANECIBLE);
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
    public static Ventana getHuespedReserva(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("HuespedReserva", Ventanas.HUESPED_RESERVA,
                owner, Ventana.resourceBundle.getString("windows.HuespedReserva"), modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getTelefonoBuscador(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("TelefonoBuscador", Ventanas.TELEFONO_BUSCADOR,
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
    public static Ventana getTelefonoFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("TelefonoFormulario", Ventanas.TELEFONO_FORMULARIO,
                owner,"Formulario Teléfono", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getCheckin(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("CheckIn", Ventanas.CHECK_IN,
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
    public static Ventana getAlojamientoFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("AlojamientoFormulario", Ventanas.ALOJAMIENTO_FORMULARIO,
                owner,"Formulario alojamiento", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getHabitacionFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("HabitacionFormulario", Ventanas.HABITACION_FORMULARIO,
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
    public static Ventana getHabitacionBuscador(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("HabitacionBuscador", Ventanas.HABITACION_BUSCADOR,
                owner,"Buscador Habitación", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getListaVacia(String owner, Modality modalidad, Object controlador,String nombreVentana) {
        Ventana obj = Ventana.crear("ListaVacia", nombreVentana,
                owner,"Lista", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getPersonaBuscador(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("PersonaBuscador", Ventanas.PERSONA_BUSCADOR,
                owner,"Persona Buscasor", modalidad, controlador,Ventanas.DESVANECIBLE);
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
    public static Ventana getPersonaFormulario(String owner, Modality modalidad, Object controlador) {
        Ventana obj = Ventana.crear("PersonaFormulario", Ventanas.PERSONA_FORMULARIO,
                owner,"Persona Formulario", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
}
