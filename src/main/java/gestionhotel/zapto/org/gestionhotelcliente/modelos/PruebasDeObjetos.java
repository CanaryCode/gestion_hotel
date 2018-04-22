package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class PruebasDeObjetos {

    public static Persona Persona0 = new Persona(0, "tipoDocumento0", "documentoNumero0", "nombre0", "calle0",
            "codPostal0", "ciudad0", "provincia0", "estado0", "nacionalidad0", Boolean.TRUE,
            "jurNombreComercial0", "fisApellidos0", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento0", new Integer("0"), "fisCargo0", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona1 = new Persona(1, "tipoDocumento1", "documentoNumero1", "nombre1", "calle1",
            "codPostal1", "ciudad1", "provincia1", "estado1", "nacionalidad1", Boolean.TRUE,
            "jurNombreComercial1", "fisApellidos1", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento1", new Integer("1"), "fisCargo1", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona2 = new Persona(2, "tipoDocumento2", "documentoNumero2", "nombre2", "calle2",
            "codPostal2", "ciudad2", "provincia2", "estado2", "nacionalidad2", Boolean.TRUE,
            "jurNombreComercial2", "fisApellidos2", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento2", new Integer("2"), "fisCargo2", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona3 = new Persona(3, "tipoDocumento3", "documentoNumero3", "nombre3", "calle3",
            "codPostal3", "ciudad3", "provincia3", "estado3", "nacionalidad3", Boolean.TRUE,
            "jurNombreComercial3", "fisApellidos3", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento3", new Integer("3"), "fisCargo3", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona4 = new Persona(4, "tipoDocumento4", "documentoNumero4", "nombre4", "calle4",
            "codPostal4", "ciudad4", "provincia4", "estado4", "nacionalidad4", Boolean.TRUE,
            "jurNombreComercial4", "fisApellidos4", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento4", new Integer("4"), "fisCargo4", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona5 = new Persona(5, "tipoDocumento5", "documentoNumero5", "nombre5", "calle5",
            "codPostal5", "ciudad5", "provincia5", "estado5", "nacionalidad5", Boolean.TRUE,
            "jurNombreComercial5", "fisApellidos5", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento5", new Integer("5"), "fisCargo5", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona6 = new Persona(6, "tipoDocumento6", "documentoNumero6", "nombre6", "calle6",
            "codPostal6", "ciudad6", "provincia6", "estado6", "nacionalidad6", Boolean.TRUE,
            "jurNombreComercial6", "fisApellidos6", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento6", new Integer("6"), "fisCargo6", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona7 = new Persona(7, "tipoDocumento7", "documentoNumero7", "nombre7", "calle7",
            "codPostal7", "ciudad7", "provincia7", "estado7", "nacionalidad7", Boolean.TRUE,
            "jurNombreComercial7", "fisApellidos7", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento7", new Integer("7"), "fisCargo7", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona8 = new Persona(8, "tipoDocumento8", "documentoNumero8", "nombre8", "calle8",
            "codPostal8", "ciudad8", "provincia8", "estado8", "nacionalidad8", Boolean.TRUE,
            "jurNombreComercial8", "fisApellidos8", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento8", new Integer("8"), "fisCargo8", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    public static Persona Persona9 = new Persona(9, "tipoDocumento9", "documentoNumero9", "nombre9", "calle9",
            "codPostal9", "ciudad9", "provincia9", "estado9", "nacionalidad9", Boolean.TRUE,
            "jurNombreComercial9", "fisApellidos9", new Date(1985, 3, 25), new Integer("20"),
            "fisTratamiento9", new Integer("9"), "fisCargo9", Boolean.FALSE, Boolean.FALSE,
            new Usuario(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(),
            new HashSet<>(), new HashSet<>());
    Persona[] listaPersonas = {
        Persona0,Persona1,Persona2,Persona3,Persona4,Persona5,Persona5,Persona6,Persona7,
        Persona8,Persona9
    };
//    ArrayList<Persona> arrayPersonas = new ArrayList<Persona>(listaPersonas);
//    ObservableList<Persona> listaPersonas=FXCollections.observableList(listaPersonas);
    public static Reserva reserva0 = new Reserva(0, Persona0, Persona0, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion0", "comentario0", new HashSet());
    public static Reserva reserva1 = new Reserva(1, Persona1, Persona1, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion1", "comentario1", new HashSet());
    public static Reserva reserva2 = new Reserva(2, Persona2, Persona2, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion2", "comentario2", new HashSet());
    public static Reserva reserva3 = new Reserva(3, Persona3, Persona3, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion3", "comentario3", new HashSet());
    public static Reserva reserva4 = new Reserva(4, Persona4, Persona4, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion4", "comentario4", new HashSet());
    public static Reserva reserva5 = new Reserva(5, Persona5, Persona5, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion5", "comentario5", new HashSet());
    public static Reserva reserva6 = new Reserva(6, Persona6, Persona6, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion6", "comentario6", new HashSet());
    public static Reserva reserva7 = new Reserva(7, Persona7, Persona7, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion7", "comentario7", new HashSet());
    public static Reserva reserva8 = new Reserva(8, Persona8, Persona8, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion8", "comentario8", new HashSet());
    public static Reserva reserva9 = new Reserva(9, Persona9, Persona9, new Date(1985, 3, 25), new Date(1985, 3, 25),
            "motivoCancelacion9", "comentario9", new HashSet());
}
