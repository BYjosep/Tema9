package com.BYjosep.Tema9.lib;

import java.util.IllegalFormatException;
import java.util.Random;

/**
 * Librería ANSI
 * Esta librería contiene algunos métodos útiles para utilizar caracteres de escape ANSI
 * Anexo: Salida con Formato
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.4, 2024-10-16
 * @since 0.1, 2021-12-03
 **/
public class ANSI {
    public static final String ESC = "\u001b[";
    public static final String RESET = ESC + "0m";
    public static final String HIGH_INTENSITY = ESC + "[1m";
    public static final String LOW_INTESITY = ESC + "[2m";
    public static final String ITALIC = ESC + "[3m";
    public static final String UNDERLINE = ESC + "[4m";
    public static final String BLINK = ESC + "[5m";
    public static final String RAPID_BLINK = ESC + "[6m";
    public static final String REVERSE_VIDEO = ESC + "[7m";
    public static final String INVISIBLE_TEXT = ESC + "[8m";
    private ANSI() {
    }

    /**
     * Genera un color ANSI aleatorio
     *
     * @return El color ANSI generado
     */
    public static Color randomColor() {
        Random random = new Random();
        int alea = random.nextInt(0, Color.values().length);
        return Color.values()[alea];
    }

    /**
     * Imprime el caracter c en la salida estándar con el color de texto (fg) y color de fondo (bg) indicados
     *
     * @param c  Caracter a imprimir
     * @param fg Color ANSI del texto
     * @param bg Color ANSI del fondo
     */
    public static void print(char c, Color fg, Color bg) {
        printTo(c, -1, -1, false, fg, bg);
    }

    /**
     * Imprime el caracter c en la columna col y fila row
     *
     * @param c   Caracter a imprimir
     * @param col Número de columna
     * @param row Número de fila
     */
    public static void printTo(char c, int col, int row) {
        printTo(c, col, row, false, Color.NONE, Color.NONE);
    }

    /**
     * Imprime el caracter c en la columna col, fila row con los colores de texto (fg) y fondo (bg) indicados.
     * Si bold es true además el caracter aparecerá en negrita.
     *
     * @param c    Caracter a imprimir
     * @param col  Número de columna
     * @param row  Número de fila
     * @param bold Determina si el caracter aparecerá en negrita o no
     * @param fg   Color ANSI del texto
     * @param bg   Color ANSI del fondo
     */
    public static void printTo(char c, int col, int row, boolean bold, Color fg, Color bg) {
        String color = getColorStr(bold, fg, bg);
        if (row > 0 || col > 0)
            System.out.print(ESC + row + ";" + col + "f");
        System.out.print(color + c);
        if (!color.isEmpty())
            System.out.print(RESET);
        System.out.flush();
    }

    /**
     * Obtiene la cadena ANSI correspondiente para representar texto con las características indicadas como parámetros.
     * Se trata de un método para uso interno. Por eso es privado
     *
     * @param bold Determina si el caracter aparecerá en negrita o no
     * @param fg   Determina el Color ANSI del texto
     * @param bg   Determina el Color ANSI del fondo
     * @return Cadena de texto que representa los colores con las características indicadas
     */
    private static String getColorStr(boolean bold, Color fg, Color bg) {
        String fgColor = getColor(fg, ColorType.FOREGROUND);
        String bgColor = getColor(bg, ColorType.BACKGROUND);
        String negrita = (bold ? "1" : "0");
        String color = "";
        if (!fgColor.isEmpty() || !bgColor.isEmpty()) {
            color = ESC + negrita;
            color += (!fgColor.isEmpty() ? ";" + fgColor : "");
            color += (!bgColor.isEmpty() ? ";" + bgColor : "");
            color += "m";
        }
        return color;
    }

    /**
     * Permite obtener una cadena con formato siguiendo los especificadores de formato de printf, con las características indicadas
     *
     * @param s    Cadena con formato a mostrar
     * @param bold Determina si el caracter aparecerá en negrita o no
     * @param fg   Determina el Color ANSI del texto
     * @param bg   Determina el Color ANSI del fondo
     * @param args Argumentos de cada especificador de formato
     * @return Cadena de texto formateada con las características indicadas
     */
    public static String format(String s, boolean bold, Color fg, Color bg, Object... args) {
        String color = getColorStr(bold, fg, bg);
        return color + String.format(s, args) + RESET;
    }

    /**
     * Imprime en la salida estándar la cadena con formato siguiendo los especificadores de formato de printf, con las características indicadas
     *
     * @param s    Cadena con formato a imprimir
     * @param bold Determina si el caracter aparecerá en negrita o no
     * @param fg   Determina el Color ANSI del texto
     * @param bg   Determina el Color ANSI del fondo
     * @param args Argumentos de cada especificador de formato
     */
    public static void printf(String s, boolean bold, Color fg, Color bg, Object... args) throws IllegalFormatException {
        String color = getColorStr(bold, fg, bg);
        // String text = String.format(s, args);
        System.out.printf(color + s, args);
        System.out.print(RESET);
        System.out.flush();
    }

    /**
     * Obtiene el número como cadena de texto que representa un determinado color ANSI
     *
     * @param color Color ANSI a obtener
     * @param ct    Tipo de color
     * @return Cadena que representa el color ANSI indicado
     */
    public static String getColor(Color color, ColorType ct) {
        String result = "";
        if (color != Color.NONE) {
            result = switch (ct) {
                case FOREGROUND -> "3" + color.ordinal();
                case BACKGROUND -> "4" + color.ordinal();
            };
        }
        return result;
    }

    /**
     * Borra la pantalla
     * Nota: El run de IntelliJ no soporta esta secuencia. Puedes probarlo con el terminal que IntelliJ lleva integrado
     */
    public static void clearScreen() {
        System.out.print(ESC + "H");
        System.out.print(ESC + "2J");
        System.out.flush();
    }

    /**
     * Oculta el cursor
     */
    public static void hideCursor() {
        System.out.print(ESC + "?25l");
        System.out.flush();
    }

    /**
     * Muestra el cursor
     */
    public static void showCursor() {
        System.out.print(ESC + "?25h");
        System.out.flush();
    }

    public enum Color {
        BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE, NONE
    }

    public enum ColorType {
        FOREGROUND, BACKGROUND
    }
}