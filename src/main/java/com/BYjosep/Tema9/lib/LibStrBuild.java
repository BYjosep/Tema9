package com.BYjosep.Tema9.lib;


public class LibStrBuild {

    /**
     * Ingrese un mensaje y devuelve la cantidad de vocales y consonantes
     * de cada palabra
     *
     * @param mensaje Inserte el mensaje en formato {@link StringBuilder String}
     * @return devuelve el valor en formato {@link StringBuilder StringBuilder}
     */
    public static StringBuilder contadorVocalesConsonantesPorPalabras(StringBuilder mensaje) {
        StringBuilder mensajeEntregado = new StringBuilder();
        String mensajeStr = mensaje.toString();
        String[] array = mensajeStr.split("\\s|\n|,");

        for (int i = 0; i < mensajeStr.split("\\s|\n|,").length; i++) {
            mensajeEntregado.append("La palabra ").append(i + 1).append(" tiene ").append(LibOutStrings.cantidadVocalesYConsonantes(array[i])).append(".\n");
        }
        return mensajeEntregado;
    }

    /**
     * Ingrese un mensaje y devuelve la cantidad de vocales y consonantes
     * de cada palabra
     *
     * @param mensaje Inserte el mensaje en formato {@link String String}
     * @return devuelve el valor en formato {@link StringBuilder StringBuilder}
     */
    public static StringBuilder contadorVocalesConsonantesPorPalabras(String mensaje) {
        StringBuilder mensajeEntregado = new StringBuilder();
        String[] array;
        array = mensaje.split("\\s|\n|,");

        for (int i = 0; i < mensaje.split("\\s|\n|,").length; i++) {
            mensajeEntregado.append("La palabra ").append(i + 1).append(" tiene ").append(LibOutStrings.cantidadVocalesYConsonantes(array[i])).append(".\n");

        }
        return mensajeEntregado;
    }


    /**
     * @param frase Ingresa una frase en formato {@link String String}
     * @param veces Ingresa el número de veces en formato {@link Integer int}
     * @return Devuelve un texto en formato {@link StringBuilder StringBuilder}
     */
    public static StringBuilder repetirFrase(StringBuilder frase, int veces) {
        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < veces; i++) {
            mensaje.append(frase).append("\n");
        }
        return mensaje;
    }

    /**
     * @param texto texto en formato {@link StringBuilder StringBuilder}
     *              para eliminar la última coma
     * @return Devuelve el texto formateado para array
     */
    public static String formatearArray(StringBuilder texto) {
        texto.delete(texto.length() - 1, texto.length());
        texto.append("]");
        return texto.toString();
    }
}
