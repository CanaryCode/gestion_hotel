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
    public static ObjetoVentana getLogIn() {
        ObjetoVentana obj = ObjetoVentana.crear("LogIn", Ventanas.LOGIN, null,
                ObjetoVentana.resourceBundle.getString("windows.logIn"), Modality.NONE, null,Ventanas.NO_DESVANECIBLE);
        return obj;
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     *
     * @return ventana preconfigurada lista para ver
     */
    public static ObjetoVentana getPrincipal() {
        ObjetoVentana obj = ObjetoVentana.crear("Principal", Ventanas.PRINCIPAL,
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
    public static ObjetoVentana getHuespedFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("HuespedFormulario", Ventanas.HUESPED_FORMULARIO,
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
    public static ObjetoVentana getPrevision(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("Prevision", Ventanas.PREVISION,
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
    public static ObjetoVentana getQuienesSomos(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("QuienesSomos", Ventanas.QUIENES_SOMOS,
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
    public static ObjetoVentana getClienteFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("ClienteFormulario", Ventanas.CLIENTE_FORMULARIO,
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
    public static ObjetoVentana getReservaFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("ReservaFormulario", Ventanas.RESERVA_FORMULARIO,
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
    public static ObjetoVentana getBuscarHuesped(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("HuespedBuscador", Ventanas.HUESPED_BUSCADOR,
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
    public static ObjetoVentana getBuscarCliente(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("ClienteBuscador", Ventanas.CLIENTE_BUSCADOR,
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
    public static ObjetoVentana getCalculadora(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("Calculadora", Ventanas.CALCULADORA,
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
    public static ObjetoVentana getHuespedReserva(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("HuespedReserva", Ventanas.HUESPED_RESERVA,
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
    public static ObjetoVentana getTelefonoBuscador(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("TelefonoBuscador", Ventanas.TELEFONO_BUSCADOR,
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
    public static ObjetoVentana getTelefonoFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("TelefonoFormulario", Ventanas.TELEFONO_FORMULARIO,
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
    public static ObjetoVentana getCheckin(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("CheckIn", Ventanas.CHECK_IN,
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
    public static ObjetoVentana getAlojamientoFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("AlojamientoFormulario", Ventanas.ALOJAMIENTO_FORMULARIO,
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
    public static ObjetoVentana getHabitacionFormulario(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("HabitacionFormulario", Ventanas.HABITACION_FORMULARIO,
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
    public static ObjetoVentana getHabitacionBuscador(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("HabitacionBuscador", Ventanas.HABITACION_BUSCADOR,
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
    public static ObjetoVentana getListaVacia(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentana.crear("ListaVacia", Ventanas.LISTA_VACIA,
                owner,"Lista", modalidad, controlador,Ventanas.DESVANECIBLE);
        return obj;
    }
}
