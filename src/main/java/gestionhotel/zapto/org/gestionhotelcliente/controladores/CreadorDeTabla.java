package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class CreadorDeTabla<T, U> {

    private String titulo, nombrePropiedad;
    private double ancho;

    public static <T, U, V> void generaTabla(Pane panelPrincipal, TableView tabla, ObservableList<T> listaItems,
            ObservableList<CreadorDeTabla> listaCreadorDeTablas) {

        ObservableList<TableColumn> listaTableColumn = FXCollections.observableArrayList();
        double ancho = 0;
        for (CreadorDeTabla creadorTabla : listaCreadorDeTablas) {
            ancho += creadorTabla.getAncho();
            TableColumn tableColumn = new TableColumn(creadorTabla.getTitulo());
            tableColumn.setPrefWidth(creadorTabla.getAncho());
            tableColumn.setCellValueFactory(
                    new PropertyValueFactory<V, U>(creadorTabla.getNombrePropiedad())
            );
            listaTableColumn.add(tableColumn);
        }
        tabla.setPrefWidth(ancho);
        tabla.setItems(listaItems);
        for (TableColumn Columna : listaTableColumn) {
            tabla.getColumns().add(Columna);
        }
    }

    public CreadorDeTabla(String titulo, String nombrePropiedad, double ancho) {
        this.titulo = titulo;
        this.nombrePropiedad = nombrePropiedad;
        this.ancho = ancho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

}
