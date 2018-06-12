/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import com.sun.javafx.application.HostServicesDelegate;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Trabajador;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Sistema {
    private static HostServicesDelegate hostServicesDelegate;
    private static Trabajador usuarioSistema;
    public static HostServicesDelegate getHostServicesDelegate() {
        return hostServicesDelegate;
    }

    public static void setHostServicesDelegate(HostServicesDelegate hostServicesDelegate) {
        Sistema.hostServicesDelegate = hostServicesDelegate;
    }

    public static Trabajador getUsuarioSistema() {
        return usuarioSistema;
    }

    public static void setUsuarioSistema(Trabajador usuarioSistema) {
        Sistema.usuarioSistema = usuarioSistema;
    }
    
}
