package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaAlojamiento {

    private LocalDate fechaInicio, fechaFin;
    private int NumeroAdultos, NumeroChild, NumeroBebes;
    private String Pension, CamaExtra, cuna, PrefTipoHabitacion, PrefHabitacion, PrefTipoCama,
            PrefVistas, PrefTurnoRestaurante, PrefTipoRestaurante;

    public static ObservableList<TablaAlojamiento> getListaTablaAlojamiento(ObservableList<DetallesReserva> listaReservas) {
        ObservableList<TablaAlojamiento> listaTablaAlojamientos = FXCollections.observableArrayList();
        for (DetallesReserva detallesReserva : listaReservas) {

            LocalDate FechaInicio = null, FechaFin = null;

            int NumeroAdultos = 0, NumeroChild = 0, NumeroBebes = 0;

            String Pension = "", CamaExtra = "", cuna = "", PrefTipoHabitacion = "",
                    PrefHabitacion = "", PrefTipoCama = "", PrefVistas = "", PrefTurnoRestaurante = "",
                    PrefTipoRestaurante = "";
            if (detallesReserva.getFechaEntradaPrevista() != null) {
                FechaInicio = detallesReserva.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (detallesReserva.getFechaSalidaPrevista() != null) {
                FechaFin = detallesReserva.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (detallesReserva.getNumeroAdultos() != null) {
                NumeroAdultos = detallesReserva.getNumeroAdultos();
            }
            if (detallesReserva.getNumeroChild() != null) {
                NumeroChild = detallesReserva.getNumeroChild();
            }
            if (detallesReserva.getNumeroBebes() != null) {
                NumeroBebes = detallesReserva.getNumeroBebes();
            }
            if (detallesReserva.getPension() != null) {
                Pension = detallesReserva.getPension();
            }
            if (detallesReserva.getCamaExtra() != null) {
                CamaExtra = (detallesReserva.getCamaExtra() == 0) ? "No" : "Si";
            }
            if (detallesReserva.getCuna() != null) {
                cuna = (detallesReserva.getCuna() == 0) ? "No" : "Si";
            }
            if (detallesReserva.getPreferenciaTipoHabitacion() != null) {
                PrefTipoHabitacion = detallesReserva.getPreferenciaTipoHabitacion();
            }
            if (detallesReserva.getPreferenciaHabitacion() != null) {
                PrefHabitacion = detallesReserva.getPreferenciaHabitacion();
            }
            if (detallesReserva.getPreferenciaTipoCama() != null) {
                PrefTipoCama = detallesReserva.getTipoCama();
            }
            if (detallesReserva.getPreferenciaVistas() != null) {
                PrefVistas = detallesReserva.getPreferenciaVistas();
            }
            if (detallesReserva.getPreferenciaTurnoRestaurante() != null) {
                PrefTurnoRestaurante = detallesReserva.getPreferenciaTurnoRestaurante();
            }
            if (detallesReserva.getPreferenciaTipoRestaurante() != null) {
                PrefTipoRestaurante = detallesReserva.getPreferenciaTipoRestaurante();
            }

            TablaAlojamiento tablaAlojamiento = new TablaAlojamiento(FechaInicio, FechaFin,
                    NumeroAdultos, NumeroChild, NumeroBebes, Pension, CamaExtra, cuna,
                    PrefTipoHabitacion, PrefHabitacion, PrefTipoCama, PrefVistas,
                    PrefTurnoRestaurante, PrefTipoRestaurante);

            listaTablaAlojamientos.add(tablaAlojamiento);
        }
        return listaTablaAlojamientos;
    }

    public TablaAlojamiento(LocalDate FechaInicio, LocalDate FechaFin, int NumeroAdultos,
            int NumeroChild, int NumeroBebes, String Pension, String CamaExtra, String cuna,
            String PrefTipoHabitacion, String PrefHabitacion, String PrefTipoCama,
            String PrefVistas, String PrefTurnoRestaurante, String PrefTipoRestaurante) {
        
        this.fechaInicio = FechaInicio;
        this.fechaFin = FechaFin;
        this.NumeroAdultos = NumeroAdultos;
        this.NumeroChild = NumeroChild;
        this.NumeroBebes = NumeroBebes;
        this.Pension = Pension;
        this.CamaExtra = CamaExtra;
        this.cuna = cuna;
        this.PrefTipoHabitacion = PrefTipoHabitacion;
        this.PrefHabitacion = PrefHabitacion;
        this.PrefTipoCama = PrefTipoCama;
        this.PrefVistas = PrefVistas;
        this.PrefTurnoRestaurante = PrefTurnoRestaurante;
        this.PrefTipoRestaurante = PrefTipoRestaurante;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate FechaInicio) {
        this.fechaInicio = FechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate FechaFin) {
        this.fechaFin = FechaFin;
    }

    public int getNumeroAdultos() {
        return NumeroAdultos;
    }

    public void setNumeroAdultos(int NumeroAdultos) {
        this.NumeroAdultos = NumeroAdultos;
    }

    public int getNumeroChild() {
        return NumeroChild;
    }

    public void setNumeroChild(int NumeroChild) {
        this.NumeroChild = NumeroChild;
    }

    public int getNumeroBebes() {
        return NumeroBebes;
    }

    public void setNumeroBebes(int NumeroBebes) {
        this.NumeroBebes = NumeroBebes;
    }

    public String getPension() {
        return Pension;
    }

    public void setPension(String Pension) {
        this.Pension = Pension;
    }

    public String getCamaExtra() {
        return CamaExtra;
    }

    public void setCamaExtra(String CamaExtra) {
        this.CamaExtra = CamaExtra;
    }

    public String getCuna() {
        return cuna;
    }

    public void setCuna(String cuna) {
        this.cuna = cuna;
    }

    public String getPrefTipoHabitacion() {
        return PrefTipoHabitacion;
    }

    public void setPrefTipoHabitacion(String PrefTipoHabitacion) {
        this.PrefTipoHabitacion = PrefTipoHabitacion;
    }

    public String getPrefHabitacion() {
        return PrefHabitacion;
    }

    public void setPrefHabitacion(String PrefHabitacion) {
        this.PrefHabitacion = PrefHabitacion;
    }

    public String getPrefTipoCama() {
        return PrefTipoCama;
    }

    public void setPrefTipoCama(String PrefTipoCama) {
        this.PrefTipoCama = PrefTipoCama;
    }

    public String getPrefVistas() {
        return PrefVistas;
    }

    public void setPrefVistas(String PrefVistas) {
        this.PrefVistas = PrefVistas;
    }

    public String getPrefTurnoRestaurante() {
        return PrefTurnoRestaurante;
    }

    public void setPrefTurnoRestaurante(String PrefTurnoRestaurante) {
        this.PrefTurnoRestaurante = PrefTurnoRestaurante;
    }

    public String getPrefTipoRestaurante() {
        return PrefTipoRestaurante;
    }

    public void setPrefTipoRestaurante(String PrefTipoRestaurante) {
        this.PrefTipoRestaurante = PrefTipoRestaurante;
    }

}
