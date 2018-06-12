package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado sirve para centralizar inputs que se
 * vayan a añadir a la base de datos, para que estén escritos correctamente.
 */
public class Registro {

    /**
     * lista de todos los paises del mundo
     */
    private static final String[] arrayPaises = {"desconocido", "España", "Alemania", "Inglaterra", "Francia", "Italia",
        "Austria", "Bèlgica", "Holanda", "Portugal", "Suiza", "Luxemburgo", "Rusia", "Suecia", "Noruega",
        "Finlandia", "Irlanda", "Escocia", "Gales", "Dinarmaca", "Polonia",
        "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita",
        "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés",
        "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia",
        "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután",
        "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre",
        "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil",
        "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador",
        "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia",
        "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada",
        "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bisáu", "Haití", "Honduras",
        "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón",
        "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait",
        "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo",
        "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México",
        "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal",
        "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos",
        "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana",
        "República Checa", "República de Macedonia", "República del Congo", "Rep Democrática del Congo",
        "República Dominicana", "República Sudafricana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves",
        "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia",
        "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudán", "Sudán del Sur",
        "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago",
        "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam",
        "Yemen", "Yibuti", "Zambia", "Zimbabue", "Otro"};

    public static final ObservableList<String> listaPaises = FXCollections.observableArrayList(arrayPaises);

    private static final String[] arrayCategoria = {
        "desconocido", "Normal", "V.I.P", "Especial", "Repetidor", "Otro"
    };
    public static final ObservableList<String> listaCategoriaHuesped = FXCollections.observableArrayList(arrayCategoria);

    private static String[] arrayPension = {
        "desconocido", "M.P.", "Completa", "Alo Y Des", "Otro"
    };
    public static final ObservableList<String> ListaPension = FXCollections.observableArrayList(arrayPension);

   private static final String[] arrayTratamiento = {
        "desconocido", "Sr/Sra", "Dr/Dra", "Ingeniero/a", "Don/Doña", "Ilustrisimo/a", "Excelentisimo/a", "Otro"
    };
    public static final ObservableList<String> ListaTratamiento = FXCollections.observableArrayList(arrayTratamiento);

    private static final String[] lenguajes = {
        "Español", "English"
    };
    public static final ObservableList<String> ListaLenguajes = FXCollections.observableArrayList(lenguajes);

    private static final String[] razonSocial = {
        "desconocido", "Emp. Individual", "S.L", "S.L.N.E", "S.A", "COOP", "C.B", "Otro"
    };
    public static final ObservableList<String> ListaRazonSocial = FXCollections.observableArrayList(razonSocial);

    private static final String[] categoriaCliente = {
        "desconocido", "Especial", "Mongolo", "Mongolo profundo", "Otro"
    };
    public static final ObservableList<String> ListaCategoriaCliente = FXCollections.observableArrayList(categoriaCliente);

    private static final String[] numeroPersonas = {
        "desconocido", "1", "2", "3", "4", "5"
    };
    public static final ObservableList<String> ListaNumeroPersonas = FXCollections.observableArrayList(numeroPersonas);

    private static final String[] tipoHabitacion = {
        "desconocido", "Individual", "Doble", "Doble superior", "Suite", "Suite junior", "Otro"
    };
    public static final ObservableList<String> ListaTipoHabitacion = FXCollections.observableArrayList(tipoHabitacion);

    private static final String[] tipoCama = {
        "desconocido", "Individual", "Matrimonio", "Doble separadas", "Otro"
    };
    public static ObservableList<String> ListaTipoCama = FXCollections.observableArrayList(tipoCama);

    private static final String[] tipoTarjeta = {
        "desconocido", "Visa", "Mastercard", "American Express", "Maestro", "ServiRed", "Otro"
    };
    public static ObservableList<String> ListaTipoTarjeta = FXCollections.observableArrayList(tipoTarjeta);

    private static final String[] agencia = {
        "desconocido", "directo", "Tui", "Jahn Raisen", "Thomson", "Expedia", "Corte ingles", "Halcon", "Otro"
    };
    public static ObservableList<String> ListaAgencia = FXCollections.observableArrayList(agencia);
    private static final String[] tiposTelefono = {
        "Desconocido", "Móvil", "Casa", "Empresa", "Fax", "Otro"
    };
    public static ObservableList<String> ListaTipoTelefono = FXCollections.observableArrayList(tiposTelefono);
    private static final String[] vistas = {
        "Desconocido", "Mar", "Montaña", "Piscina", "Calle", "Otro"
    };
    public static ObservableList<String> ListaVistas = FXCollections.observableArrayList(vistas);
    private static final String[] turnoRestaurante = {
        "Desconocido", "Primero", "Segundo", "Tercero", "Otro"
    };
    public static ObservableList<String> ListaTurnoRestaurante = FXCollections.observableArrayList(turnoRestaurante);
    private static final String[] tiposRestaurante = {
        "Desconocido", "Principal", "Tradicional", "Mexicano", "Tailandés", "Otro"
    };
    public static ObservableList<String> ListaTipoRestaurante = FXCollections.observableArrayList(tiposRestaurante);
    private static final String[] numeroHabitacion = {
        "1", "2", "3", "4", "5", "6"
    };
    public static ObservableList<String> ListaNumeroHabitacion= FXCollections.observableArrayList(numeroHabitacion);
   
    private static final String[] estadoHabitacion = {
        "Desconocido", "Ocupada", "Libre"
    };
    public static ObservableList<String> ListaEstadoHabitacion= FXCollections.observableArrayList(estadoHabitacion);
   
    private static final String[] departamentos = {
        "Desconocido", "Dirección", "Recepción","SSTT","Cocina","RRHH","Economato"
    };
    public static ObservableList<String> ListaDeparmentos= FXCollections.observableArrayList(departamentos);
   
}
