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
        "Yemen", "Yibuti", "Zambia", "Zimbabue"};

    public static final ObservableList listaPaises = FXCollections.observableArrayList(arrayPaises);

    private static final String[] arrayCategoria = {
        "Normal", "V.I.P", "Especial", "Repetidor"
    };
    public static final ObservableList listaCategoriaHuesped = FXCollections.observableArrayList(arrayCategoria);

    private static String[] arrayPension = {
        "M.P.", "Completa", "Alo Y Des"
    };
    public static final ObservableList ListaPension = FXCollections.observableArrayList(arrayPension);

    private static final String[] arrayHabitacion = {
        "11", "13", "412"
    };
    public static final ObservableList ListaHabitacion = FXCollections.observableArrayList(arrayHabitacion);
    private static final String[] arrayTratamiento = {
        "ninguno", "Sr/Sra", "Dr/Dra", "Ingeniero/a", "Don/Doña", "Ilustrisimo/a", "Excelentisimo/a"
    };
    public static final ObservableList ListaTratamiento = FXCollections.observableArrayList(arrayTratamiento);

    private static final String[] lenguajes = {
        "Español", "English"
    };
    public static final ObservableList ListaLenguajes = FXCollections.observableArrayList(lenguajes);

    private static final String[] razonSocial = {
        "desconocido", "Emp. Individual", "S.L", "S.L.N.E", "S.A", "COOP", "C.B"
    };
    public static final ObservableList ListaRazonSocial = FXCollections.observableArrayList(razonSocial);

    private static final String[] categoriaCliente = {
        "desconocido", "Especial", "Mongolo", "Mongolo profundo"
    };
    public static final ObservableList ListaCategoriaCliente = FXCollections.observableArrayList(categoriaCliente);

    private static final String[] numeroPersonas = {
        "1", "2", "3", "4", "5"
    };
    public static final ObservableList ListaNumeroPersonas = FXCollections.observableArrayList(numeroPersonas);

    private static final String[] tipoHabitacion = {
        "Individual", "Doble", "Doble superior", "Suite", "Suite junior"
    };
    public static final ObservableList ListaTipoHabitacion = FXCollections.observableArrayList(tipoHabitacion);

    private static final String[] tipoCama = {
        "Individual", "Matrimonio", "Doble separadas"
    };
    public static ObservableList ListaTipoCama = FXCollections.observableArrayList(tipoCama);

    private static final String[] tipoTarjeta = {
        "Visa", "Mastercard", "American Express", "Maestro", "ServiRed"
    };
    public static ObservableList ListaTipoTarjeta = FXCollections.observableArrayList(tipoTarjeta);

    private static final String[] agencia = {
        "desconocida", "directo","Tui", "Jahn Raisen", "Thomson", "Expedia", "Corte ingles", "Halcon"
    };
    public static ObservableList ListaAgencia = FXCollections.observableArrayList(agencia);

}
