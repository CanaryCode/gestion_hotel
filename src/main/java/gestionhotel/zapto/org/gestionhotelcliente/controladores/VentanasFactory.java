/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class VentanasFactory {

    /**
     * abre la ventana de "Log-in". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     */
    public static ObjetoVentana getObjetoVentanaLogIn() {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaLogIn", Ventanas.LOGIN, null,
                ObjetoVentana.resourceBundle.getString("windows.logIn"), Modality.NONE, null);
        return obj;
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     */
    public static ObjetoVentana getObjetoVentanaPrincipal() {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaPrincipal",Ventanas.PRINCIPAL,
                null, ObjetoVentana.resourceBundle.getString("windows.principal"), Modality.NONE,null);
        obj.getVentana().setOnCloseRequest(Event -> {
            obj.cerrar();
            AbrirCerrarConexiones.cerrar();
        });
        return obj;

    }

    /**
     * abre la ventana "Huesped". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public static ObjetoVentana getObjetoVentanaHuesped(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaHuesped", Ventanas.HUESPED,
                owner, ObjetoVentana.resourceBundle.getString("windows.huesped"), modalidad,controlador);
        return obj;
    }

    /**
     * abre la ventana Reserva "Check-In". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public static ObjetoVentana getObjetoVentanaReservaCheckIn(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaReservaCheckIn", Ventanas.RESERVA_CHECKIN,
                owner, ObjetoVentana.resourceBundle.getString("windows.checkIn"), modalidad,controlador);
        return obj;
    }

    /**
     * abre la ventana "quienes somos". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public static ObjetoVentana getObjetoVentanaQuienesSomos(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaQuienesSomos", Ventanas.QUIENES_SOMOS,
                owner, ObjetoVentana.resourceBundle.getString("windows.quienesSomos"), modalidad,controlador);
        return obj;
    }

    /**
     * abre la ventana "Registro Clientes". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public static ObjetoVentana getObjetoVentanaRegistroClientes(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaCliente", Ventanas.CLIENTE,
                owner, ObjetoVentana.resourceBundle.getString("windows.cliente"), modalidad,controlador);
        return obj;
    }

    public static ObjetoVentana getObjetoVentanaAddReserva(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaReserva", Ventanas.RESERVA,
                owner, ObjetoVentana.resourceBundle.getString("windows.addReserva"), modalidad,controlador);
        return obj;
    }

    public static ObjetoVentana getObjetoVentanaBuscarHuesped(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaHuespedBuscador", Ventanas.HUESPED_BUSCADOR,
                owner, ObjetoVentana.resourceBundle.getString("windows.huespedBuscador"), modalidad,controlador);
        return obj;
    }

    public static ObjetoVentana getObjetoVentanaBuscarCliente(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaClienteBuscador", Ventanas.CLIENTE_BUSCADOR,
                owner, ObjetoVentana.resourceBundle.getString("windows.clienteBuscador"), modalidad,controlador);
        return obj;
    }

    public static ObjetoVentana getObjetoVentanaCalculadora(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLCalculadora", Ventanas.CALCULADORA,
                owner, ObjetoVentana.resourceBundle.getString("windows.calculadora"), modalidad,controlador);
        return obj;
    }

    public static ObjetoVentana getObjetoVentanaHuespedReserva(String owner, Modality modalidad, Object controlador) {
        ObjetoVentana obj = ObjetoVentanaBuilder.crear("FXMLVentanaHuespedReserva", Ventanas.HUESPED_RESERVA,
                owner, ObjetoVentana.resourceBundle.getString("windows.HuespedReserva"), modalidad,controlador);
        return obj;
    }
}
