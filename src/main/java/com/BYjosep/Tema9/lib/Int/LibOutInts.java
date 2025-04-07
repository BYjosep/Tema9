package com.BYjosep.Tema9.lib.Int;

import java.util.Random;

/**
 * {@author BYjosep04}
 */
public class LibOutInts {


    /**
     * @param mensaje Variable como {@link StringBuilder StringBuilder}
     * @return Devuelve un entero como valor
     */
    public static int contadorPalabras(StringBuilder mensaje) {
        String mensajeStr = mensaje.toString();
        mensajeStr = mensajeStr.trim();

        return mensajeStr.split("\\s|\n").length;
    }

    /**
     * Cuenta las ocurrencias de la última letra del texto
     *
     * @param texto Ingrese el texto en formato {@link  String String}
     * @return Devuelve un numero de tipo {@link Integer int}
     */
    public static int ocurrenciasDeUltimoCaracter(String texto) {
        char ultimaLetra;
        ultimaLetra = texto.charAt(texto.length() - 1);
        int ocurrencias = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (ultimaLetra == texto.charAt(i)) {
                ocurrencias++;
            }
        }
        return ocurrencias;

    }


    /**
     * @param mensaje Variable como {@link String String}
     * @return Devuelve un entero como valor
     */
    public static int contadorPalabras(String mensaje) {
        mensaje = mensaje.trim();

        return mensaje.split("\\s|\n").length;
    }


    /**
     * @param array genera número aleatorio dentro de un {@link java.util.Arrays array} de
     *              n numeros de formato {@link Integer int}
     */
    public static void generadorAleatorio(int[] array, int min, int max) {
        Random random = new Random();
        max += 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max);
        }

    }
}

