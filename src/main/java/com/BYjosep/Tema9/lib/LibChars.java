package com.BYjosep.Tema9.lib;

import java.util.Scanner;

public class LibChars {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * cerrar {@link Scanner Scanner}
     */
    public static void cerrarScaner() {
        scanner.close();
    }


    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Character char}
     */
    public static char ingresarUnCaracter(String texto) {
        String palabra;

        do {
            System.out.println(texto);
            palabra = scanner.nextLine();
        } while (palabra.length() != 1);

        return palabra.charAt(0);
    }

    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Character char}
     */
    public static char ingresarUnCaracter(String texto,char[] caracteresPermitidos) {
        String palabra;
        boolean valido = false;
        do {
            System.out.println(texto);
            palabra = scanner.nextLine();
            if (palabra.length() != 1) {
                for (char caracter : caracteresPermitidos) {
                    if (caracter == palabra.charAt(0)) {
                        valido = true;
                        break;
                    }

                }
            }else {
                valido = true;
            }
        } while (!valido);

        return palabra.charAt(0);
    }


    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Character char}
     */
    public static char ingresarUnCaracter(String texto,char[] caracteresPermitidos, String mensajeDeError) {
        String palabra;
        boolean valido = false;
        do {
            System.out.println(texto);
            palabra = scanner.nextLine();
            if (palabra.length() != 1) {
                for (char caracter : caracteresPermitidos) {
                    if (caracter == palabra.charAt(0)) {
                        valido = true;
                        break;
                    }

                }
            }else {
                valido = true;
            }
            if (!valido) {
                ANSI.printf(mensajeDeError,false, ANSI.Color.RED, ANSI.Color.NONE);
            }
        } while (!valido);

        return palabra.charAt(0);
    }

}

