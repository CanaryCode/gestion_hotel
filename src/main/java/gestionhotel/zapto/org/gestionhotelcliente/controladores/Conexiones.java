/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Conexiones {

    private static SessionFactory sessionFactory;
    private static Session session;
   
    public static void abrir() {
        session = sessionFactory.openSession();
    }
    public static void abrirFactory() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static void cerrar() {
        session.close();
    }
    public static void cerrarFactory() {
        sessionFactory.close();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        Conexiones.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        Conexiones.session = session;
    }

}
