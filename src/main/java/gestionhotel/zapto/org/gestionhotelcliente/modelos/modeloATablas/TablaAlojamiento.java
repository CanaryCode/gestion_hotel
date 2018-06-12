package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaAlojamiento implements TablaInterface<TablaAlojamiento, Alojamiento> {

    private LocalDate fechaInicio, fechaFin;
    private int numeroAdultos, numeroChild, numeroBebes;
    private String pension, prefTipoHabitacion, prefHabitacion, prefTipoCama,
            prefVistas, prefTurnoRestaurante, prefTipoRestaurante;
    
    ImageView cuna,camaExtra;

    public TablaAlojamiento() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Prevision llegada", "fechaInicio", 100));
        lista.add(new CreadorDeTabla("Prevision salida", "fechaFin", 100));
        lista.add(new CreadorDeTabla("Numero adultos", "numeroAdultos", 100));
        lista.add(new CreadorDeTabla("Numero niños", "numeroChild", 100));
        lista.add(new CreadorDeTabla("Numero bebes", "numeroBebes", 100));
        lista.add(new CreadorDeTabla("Pensión", "pension", 100));
        lista.add(new CreadorDeTabla("Cama extra", "camaExtra", 100));
        lista.add(new CreadorDeTabla("Cuna", "cuna", 100));
        lista.add(new CreadorDeTabla("Pref. Número habitación", "prefHabitacion", 100));
        lista.add(new CreadorDeTabla("Pref. Tipo habitación", "prefTipoHabitacion", 100));
        lista.add(new CreadorDeTabla("Pref. Tipo cama", "prefTipoCama", 100));
        lista.add(new CreadorDeTabla("Pref. Vistas", "prefVistas", 100));
        lista.add(new CreadorDeTabla("Pref. Turno Restaurante", "prefTurnoRestaurante", 100));
        lista.add(new CreadorDeTabla("Pref. Tipo Restaurante", "prefTipoRestaurante", 100));

        return lista;
    }

    @Override
    public ObservableList<TablaAlojamiento> getListaObjetosDeTabla(ObservableList<Alojamiento> listaAlojamientos){
        ObservableList<TablaAlojamiento> listaTablaAlojamientos = FXCollections.observableArrayList();
        for (Alojamiento alojamiento : listaAlojamientos) {

            LocalDate FechaInicio = null, FechaFin = null;

            int NumeroAdultos = 0, NumeroChild = 0, NumeroBebes = 0;

            String Pension = "", PrefTipoHabitacion = "",
                    PrefHabitacion = "", PrefTipoCama = "", PrefVistas = "", PrefTurnoRestaurante = "",
                    PrefTipoRestaurante = "";
            ImageView CamaExtra = null, cuna = null;
            if (alojamiento.getFechaEntradaPrevista() != null) {
                FechaInicio = alojamiento.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (alojamiento.getFechaSalidaPrevista() != null) {
                FechaFin = alojamiento.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (alojamiento.getNumeroAdultos() != null) {
                NumeroAdultos = alojamiento.getNumeroAdultos();
            }
            if (alojamiento.getNumeroChild() != null) {
                NumeroChild = alojamiento.getNumeroChild();
            }
            if (alojamiento.getNumeroBebes() != null) {
                NumeroBebes = alojamiento.getNumeroBebes();
            }
            if (alojamiento.getPension() != null) {
                Pension = alojamiento.getPension();
            }
            if (alojamiento.getCamaExtra() != null) {
                CamaExtra = (alojamiento.getCamaExtra() == false) ?  new ImageView(new Image(getClass().getResource("/imagenes/tablas/no.png").toExternalForm())) :
                            new ImageView(new Image(getClass().getResource("/imagenes/tablas/si.png").toExternalForm()));
                
            }
            if (alojamiento.getCuna() != null) {
                cuna = (alojamiento.getCuna() == false) ? new ImageView(new Image(getClass().getResource("/imagenes/tablas/no.png").toExternalForm())) :
                            new ImageView(new Image(getClass().getResource("/imagenes/tablas/si.png").toExternalForm()));
            }
            if (alojamiento.getPrefTipoHabitacion() != null) {
                PrefTipoHabitacion = alojamiento.getPrefTipoHabitacion();
            }
            if (alojamiento.getPrefHabitacion() != null) {
                PrefHabitacion = alojamiento.getPrefHabitacion();
            }
            if (alojamiento.getPrefTipoCama() != null) {
                PrefTipoCama = alojamiento.getTipoCama();
            }
            if (alojamiento.getPrefVistas() != null) {
                PrefVistas = alojamiento.getPrefVistas();
            }
            if (alojamiento.getPrefTurnoRestaurante() != null) {
                PrefTurnoRestaurante = alojamiento.getPrefTurnoRestaurante();
            }
            if (alojamiento.getPrefTipoRestaurante() != null) {
                PrefTipoRestaurante = alojamiento.getPrefTipoRestaurante();
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
            int NumeroChild, int NumeroBebes, String Pension, ImageView CamaExtra, ImageView cuna,
            String PrefTipoHabitacion, String PrefHabitacion, String PrefTipoCama,
            String PrefVistas, String PrefTurnoRestaurante, String PrefTipoRestaurante) {

        this.fechaInicio = FechaInicio;
        this.fechaFin = FechaFin;
        this.numeroAdultos = NumeroAdultos;
        this.numeroChild = NumeroChild;
        this.numeroBebes = NumeroBebes;
        this.pension = Pension;
        this.camaExtra = CamaExtra;
        this.cuna = cuna;
        this.prefTipoHabitacion = PrefTipoHabitacion;
        this.prefHabitacion = PrefHabitacion;
        this.prefTipoCama = PrefTipoCama;
        this.prefVistas = PrefVistas;
        this.prefTurnoRestaurante = PrefTurnoRestaurante;
        this.prefTipoRestaurante = PrefTipoRestaurante;
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
        return numeroAdultos;
    }

    public void setNumeroAdultos(int NumeroAdultos) {
        this.numeroAdultos = NumeroAdultos;
    }

    public int getNumeroChild() {
        return numeroChild;
    }

    public void setNumeroChild(int NumeroChild) {
        this.numeroChild = NumeroChild;
    }

    public int getNumeroBebes() {
        return numeroBebes;
    }

    public void setNumeroBebes(int NumeroBebes) {
        this.numeroBebes = NumeroBebes;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String Pension) {
        this.pension = Pension;
    }

    public String getPrefTipoHabitacion() {
        return prefTipoHabitacion;
    }

    public void setPrefTipoHabitacion(String PrefTipoHabitacion) {
        this.prefTipoHabitacion = PrefTipoHabitacion;
    }

    public String getPrefHabitacion() {
        return prefHabitacion;
    }

    public void setPrefHabitacion(String PrefHabitacion) {
        this.prefHabitacion = PrefHabitacion;
    }

    public String getPrefTipoCama() {
        return prefTipoCama;
    }

    public void setPrefTipoCama(String PrefTipoCama) {
        this.prefTipoCama = PrefTipoCama;
    }

    public String getPrefVistas() {
        return prefVistas;
    }

    public void setPrefVistas(String PrefVistas) {
        this.prefVistas = PrefVistas;
    }

    public String getPrefTurnoRestaurante() {
        return prefTurnoRestaurante;
    }

    public void setPrefTurnoRestaurante(String PrefTurnoRestaurante) {
        this.prefTurnoRestaurante = PrefTurnoRestaurante;
    }

    public String getPrefTipoRestaurante() {
        return prefTipoRestaurante;
    }

    public void setPrefTipoRestaurante(String PrefTipoRestaurante) {
        this.prefTipoRestaurante = PrefTipoRestaurante;
    }

    public ImageView getCuna() {
        return cuna;
    }

    public void setCuna(ImageView cuna) {
        this.cuna = cuna;
    }

    public ImageView getCamaExtra() {
        return camaExtra;
    }

    public void setCamaExtra(ImageView camaExtra) {
        this.camaExtra = camaExtra;
    }

}
