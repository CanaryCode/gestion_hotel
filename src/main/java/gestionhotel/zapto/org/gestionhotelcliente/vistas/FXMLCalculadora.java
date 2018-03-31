package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class FXMLCalculadora implements Initializable {

    @FXML
    private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero,
            punto, igual, mas, menos, multiplicar, dividir, porcentaje, masMenos,
            elevado, borra, borraTodo, portaPapeles;
    @FXML
    private TextArea pantalla;

    private String primerNumero = "", segundoNumero = "", signo = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //se ponen a la escucha todos los botones y se enlazan con su metodo.
        uno.setOnAction((e) -> {
            accionBoton1();
        });
        dos.setOnAction((e) -> {
            accionBoton2();
        });
        tres.setOnAction((e) -> {
            accionBoton3();
        });
        cuatro.setOnAction((e) -> {
            accionBoton4();
        });
        cinco.setOnAction((e) -> {
            accionBoton5();
        });
        seis.setOnAction((e) -> {
            accionBoton6();
        });
        siete.setOnAction((e) -> {
            accionBoton7();
        });
        ocho.setOnAction((e) -> {
            accionBoton8();
        });
        nueve.setOnAction((e) -> {
            accionBoton9();
        });
        cero.setOnAction((e) -> {
            accionBoton0();
        });
        punto.setOnAction((e) -> {
            accionBotonPunto();
        });
        igual.setOnAction((e) -> {
            accionBotonIgual();
        });
        mas.setOnAction((e) -> {
            accionBotonMas();
        });
        menos.setOnAction((e) -> {
            accionBotonMenos();
        });
        multiplicar.setOnAction((e) -> {
            accionBotonMultiplicado();
        });
        dividir.setOnAction((e) -> {
            accionBotonDividido();
        });
        porcentaje.setOnAction((e) -> {
            accionBotonPorcentaje();
        });
        masMenos.setOnAction((e) -> {
            accionBotonSigno();
        });

        elevado.setOnAction((e) -> {
            accionBotonElevado();
        });
        borra.setOnAction((e) -> {
            accionBotonBorrar();
        });
        borraTodo.setOnAction((e) -> {
            accionBotonBorrarTodo();
        });
        portaPapeles.setOnAction((e) -> {
            accionBotonPortaPapeles();
        });
    }
//escribe el numero que se pinchó en cada botón.
    private void accionBoton1() {
        acumulaNumeros("1");
        escribeEnPantalla();
    }

    private void accionBoton2() {
        acumulaNumeros("2");
        escribeEnPantalla();
    }

    private void accionBoton3() {
        acumulaNumeros("3");
        escribeEnPantalla();
    }

    private void accionBoton4() {
        acumulaNumeros("4");
        escribeEnPantalla();
    }

    private void accionBoton5() {
        acumulaNumeros("5");
        escribeEnPantalla();
    }

    private void accionBoton6() {
        acumulaNumeros("6");
        escribeEnPantalla();
    }

    private void accionBoton7() {
        acumulaNumeros("7");
        escribeEnPantalla();
    }

    private void accionBoton8() {
        acumulaNumeros("8");
        escribeEnPantalla();
    }

    private void accionBoton9() {
        acumulaNumeros("9");
        escribeEnPantalla();
    }

    private void accionBoton0() {
        acumulaNumeros("0");
        escribeEnPantalla();
    }
//escribe cada operacion que se pincho en cada boton.
    private void accionBotonMas() {
        addSigno("+");
        escribeEnPantalla();
    }

    private void accionBotonMenos() {
        addSigno("-");
        escribeEnPantalla();
    }

    private void accionBotonDividido() {
        addSigno("/");
        escribeEnPantalla();
    }

    private void accionBotonMultiplicado() {
        addSigno("*");
        escribeEnPantalla();
    }

    private void accionBotonElevado() {
        addSigno("^");
        escribeEnPantalla();
    }

    private void accionBotonPorcentaje() {
        addSigno("%");
        escribeEnPantalla();
    }
//escribe el resultado de la operacion que se ha escrito.
    private void accionBotonIgual() {
        hacerOperacion();
        escribeEnPantalla();
    }
//escribe el punto al numero que se haya indicado.
    private void accionBotonPunto() {
        ponComa();
        escribeEnPantalla();
    }

    /**
     * sirve para borrar hacia a detrás los caracteres del primer y el segundo
     * numero e incluso el signo.
     */
    private void accionBotonBorrar() {
        //si hay un numero en el segundoNumero
        if (!segundoNumero.equals("")) {
            //segundo numero será igual a si mimso menos la última posición.
            segundoNumero = segundoNumero.substring(0, segundoNumero.length() - 1);
            //si hay algo en el signo borralo
        } else if (!signo.equals("")) {
            signo = "";
            //si hay un numero en primerNumero
        } else if (!primerNumero.equals("")) {
            //si solo hay una posicion numero en primer numero
            if (primerNumero.length() == 0) {
                //resetea primer numero
                primerNumero = "";
                //si hay mas de una posicion en primer numero primer numero sera
                //igual asi mismo menos una posición.
            } else {
                primerNumero = primerNumero.substring(0, primerNumero.length() - 1);
            }
        }
        //por ultimo escribe pantalla.
        escribeEnPantalla();
    }

    /**
     * sirva para borrar toda la pantalla y resetear todos los atributos de
     * clase.
     */
    private void accionBotonBorrarTodo() {
        //resetea todos los atributos y escribe en pantalla.
        //al no haber nada. limpiará todo.
        primerNumero = "";
        signo = "";
        segundoNumero = "";
        escribeEnPantalla();
    }

    private void accionBotonPortaPapeles() {

    }

    /**
     * sirve para cambiarle el signo al numero que estemos escribiendo en ese
     * momento ya puede ser el primer numero o el segundo numero.
     */
    private void accionBotonSigno() {
        //si no se ha empezado a escribir en el segundo numero.
        if (segundoNumero.equals("")) {
            //si en la primera posicion en de primerNumero hay un menos
            if (primerNumero.charAt(0) == '-') {
                //entonces quitale el menos.
                primerNumero = primerNumero.substring(1, primerNumero.length());
                //si en la primera posicion en de primerNumero no hay un menos
            } else {
                //entonces ponle  el menos en la primera posicion.
                primerNumero = "-" + primerNumero;
            }
            //si se ha empezado a escribir en el segundo numero.
        } else {
            //si en la primera posicion en de segundoNumero hay un menos
            if (segundoNumero.charAt(0) == '-') {
                //entonces quitale el menos.
                segundoNumero = segundoNumero.substring(1, segundoNumero.length());
                //si en la primera posicion en de segundoNumero no hay un menos
            } else {
                //entonces ponle  el menos en la primera posicion.
                segundoNumero = "-" + segundoNumero;
            }
        }
        escribeEnPantalla();
    }

    /**
     *sirve para determinar donde va la coma.
     */
    private void ponComa() {
        //si no hay nada en el segundo numero
        if (segundoNumero.equals("")) {
            //y si hay algo en el primer numero y no hay ya una coma puesta.
            if (!primerNumero.equals("") && !primerNumero.contains(".")) {
                //entonces concatena una coma al primer numero.
                primerNumero += ".";
                //si hay ya una coma puesta.
            } else {
                //emite un sonido de error y no hagas nada.
                Toolkit.getDefaultToolkit().beep();
            }
            //si hay algo en el segundo numero.
        } else {
            //y si el segundo numero no tiene una coma.
            if (!segundoNumero.contains(".")) {
                //entonces concatena una coma.
                segundoNumero += ".";
                //si ya tiene una coma puesta
            } else {
                //emite un sonido de error y no hagas nada.
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    /**
     * sirve para determinar donde se debe escribir el numero pulsado si en el
     * primer numero o en el segundo numero
     *
     * @param tecla el valor de la tecla pulsada.
     */
    private void acumulaNumeros(String tecla) {
        //si no esta escrito el signo
        if (signo.equals("")) {
            //concatena el valor del primer numero con la tecla pulsada.
            primerNumero += tecla;
            //si esta escrito el signo
        } else {
            //concatena el valor del segundo numero con la tecla pulsada.
            segundoNumero += tecla;
        }
    }

    /**
     * sirve para rellenar el campo signo.
     *
     * @param tecla El Char de la tecla que se ha pulsado.
     */
    private void addSigno(String tecla) {
        //si no hay nada escrito en signo
        if (signo.equals("")) {
            //signo será igual al valor de la tecla pulsada.
            signo = tecla;
            //si hay algo escrito en signo
        } else {
            //realiza la operación que esta pendiente.
            accionBotonIgual();
            //y añade y cambia el signo por el de la tecla pulsada.
            addSigno(tecla);
        }
    }

    /**
     * sirve para escribir en el area de texto los numeros de la operaciones el
     * signo y el resultado de la misma. se han puesto los numeros de las
     * operaciones entre parentesis para que sea mas fácil para distinguir
     * cuando hay numeros negativos.
     */
    private void escribeEnPantalla() {
        //el primer numero a operar que aparecerá en la pantalla metido entre parentesis
        String primerTermino = "(" + primerNumero + ")";
        //el primer segundo a operar que aparecerá en la pantalla metido entre parentesis
        String segundoTermino = "(" + segundoNumero + ")";
        //si el primer numero y el signo y el segundo numero escribe todo en pantalla.
        if (!primerNumero.equals("") && !signo.equals("") && !segundoNumero.equals("")) {
            pantalla.setText(primerTermino + signo + segundoTermino);
            //si solo existe el primer numero y el signo escribe a estos solamente en pantalla.
        } else if (!primerNumero.equals("") && !signo.equals("") && segundoNumero.equals("")) {
            pantalla.setText(primerTermino + signo);
            //si solo existe el primer numero escribe a este en pantalla.
        } else if (!primerNumero.equals("") && signo.equals("")) {
            pantalla.setText(primerTermino);
            //si no existe nada borra la pantalla.
        } else if (primerNumero.equals("")) {
            pantalla.setText("");
        }
    }

    /**
     * Discrimina que tipo de operación de ha hecho, y en base a esto hace la
     * operación con este método nos ahorramos código repetitivo empleado para
     * todas las operaciones.
     *
     * @return devuelve el resultado de la operación en forma de String
     */
    private String hacerOperacion() {
        //creamos el bigDecimal que será el el usaremoos para recoger el resultado
        // de cada operación.
        BigDecimal resultado = null;
        //miramos que se pueda hacer la operación y para esto le decimos que exista
        //el primerNumero el signo y el segundo número y que además el segundo numero no acabe en un punto..
        if (!primerNumero.equals("") && !segundoNumero.equals("") && !signo.equals("")) {
            //si la operacion es una suma.
            if (signo.equals("+")) {
                resultado = new BigDecimal(primerNumero).add(new BigDecimal(segundoNumero));
            }
            //si la operación es una resta.
            if (signo.equals("-")) {
                resultado = new BigDecimal(primerNumero).subtract(new BigDecimal(segundoNumero));
            }
            //si la operación es una multiplicación.
            if (signo.equals("*")) {
                resultado = new BigDecimal(primerNumero).multiply(new BigDecimal(segundoNumero));
            }
            //si la operación es una división.
            if (signo.equals("/")) {
                //si el segundo número a dividir no es un 0.
                if (!segundoNumero.equals("0")) {
                    resultado = new BigDecimal(primerNumero).divide(new BigDecimal(segundoNumero), 10, RoundingMode.HALF_UP);
                    //pasamos el resultado a un String
                    String s = resultado.toString();
                    //creamos un entero para almacenar el valor del la "i" en el for
                    int ultimoNumero = 0;
                    //iteramos los caracteres de la palabra desde el último hasta el primero
                    //(Esto lo hacemos para quitar los ceros que sobran después de la coma).
                    //los ceros a la izquierda.
                    for (int i = s.length(); i == 0; i--) {
                        //si el caracter que estamos evaluando es un punto o es un "0",
                        if (s.charAt(i) == '.' || s.charAt(i) == '0') {
                            //entonces almacenamos el valor que tiene la i en ultimo numero.
                            ultimoNumero = i;
                        } else {
                            //si no es un punto o un 0 salimos del bucle
                            break;
                        }
                    }
                    //decimos que el String del resultado va desde el indice 0 hasta
                    //donde se iteró el último numero el bucle for 
                    s = s.substring(0, ultimoNumero);
                    //decimos que el resultado es igual a un nevo bigDecimal creado 
                    //con el resultado de la operacón anterior
                    resultado = new BigDecimal(s);

                } else {
                    //si el segundo numero es igual a O
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            //si la operacion es un porcentaje.
            if (signo.equals("%")) {
                resultado = new BigDecimal(primerNumero).multiply(new BigDecimal(segundoNumero)).divide(new BigDecimal("100"));
            }
            //si la operacion es una potencia.
            if (signo.equals("^")) {
                resultado = new BigDecimal(primerNumero).pow(Integer.parseInt(segundoNumero));
            }

        }
        //al final de hacer lass operaciones se resetean los valores del signo y del segundo numero.
        signo = "";
        segundoNumero = "";
        //si resultado de la operacion es un null porque ha habido un error el resultado
        //se reinicia a 0 para que pueda ser parseado.
        if (resultado == null) {
            return primerNumero= "";
            //si hay un resultado valido, el primer numero tomará ese resultado como valor.
        } else {
            return primerNumero = resultado.toString();
        }
    }
}
