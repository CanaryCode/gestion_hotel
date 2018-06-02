package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaReserva implements TablaInterface<TablaReserva, Reserva>{

    String nombreAgencia, nombreCliente, numeroReserva;
   public TablaReserva(){
       
   }
    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Número Reserva", "numeroReserva", 200));
        lista.add(new CreadorDeTabla("Nombre cliente", "nombreCliente", 500));
        lista.add(new CreadorDeTabla("Nombre agencia", "nombreAgencia", 500));
        return lista;
    }

    @Override
    public  ObservableList<TablaReserva> getListaObjetosDeTabla(ObservableList<Reserva> listaReservas) {
        ObservableList<TablaReserva> listaTablaReserva = FXCollections.observableArrayList();
        for (Reserva reserva : listaReservas) {
            String nombreAgencia = "";
            String nombreCliente = "";
            String numero = "";
            if (reserva.getNumero() != null) {
                numero = reserva.getNumero();
            }
            if (reserva.getPersonaByAgencia() != null) {
                nombreAgencia = reserva.getPersonaByAgencia().getJurNombreComercial();
            }
            if (reserva.getPersonaByCodCliente() != null) {
                if (reserva.getPersonaByCodCliente().getEsEmpresa().byteValue() == 1) {
                    nombreCliente = reserva.getPersonaByCodCliente().getJurNombreComercial();
                }else{
                    nombreCliente = reserva.getPersonaByCodCliente().getNombre()+" "+
                             reserva.getPersonaByCodCliente().getFisPrimerApellido()+" "+
                             reserva.getPersonaByCodCliente().getFisSegundoApellido();
                }
            }
            TablaReserva tablaReserva = new TablaReserva(nombreAgencia, nombreCliente, numero);
            listaTablaReserva.add(tablaReserva);
        }
        return listaTablaReserva;
    }

    public TablaReserva(String nombreAgencia, String nombreCliente, String codigoReserva) {
        this.nombreAgencia = nombreAgencia;
        this.nombreCliente = nombreCliente;
        this.numeroReserva = codigoReserva;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

}
