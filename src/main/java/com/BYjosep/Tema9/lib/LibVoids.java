package com.BYjosep.Tema9.lib;

import com.BYjosep.Tema9.lib.Int.LibOutInts;

public class LibVoids {
    /**
     * @param nombre          Nombre ingresado
     * @param primerApellido  Primer apellido ingresado
     * @param segundoApellido Segundo apellido ingresado
     */
    public static void concentrador(String nombre, String primerApellido, String segundoApellido) {
        String nombreStr = nombre + " " + primerApellido + " " + segundoApellido;

        System.out.println(LibOutStrings.nombreCompletoEnMayusculasMinusculasYLongitud(nombreStr));
        primerosCincoCaracteres(nombreStr);

        System.out.println("Hay " + LibOutInts.ocurrenciasDeUltimoCaracter(nombreStr) + " ocurrencias en el nombre completo");
        System.out.println(LibOutStrings.ocurrenciaPrimeraLetraEnMayuscula(nombreStr));
        System.out.println(LibOutStrings.cadenaConSimbolosDelanteDetras(nombreStr));
        System.out.println(LibOutStrings.cadenaInvertida(nombreStr));
    }


    /**
     * @param nombreComppleto El nombre completo en formato {@link String String}
     */
    public static void primerosCincoCaracteres(String nombreComppleto) {
        StringBuilder letras = new StringBuilder();
        if (nombreComppleto.length() > 5) {
            for (int i = 0; i < 5; i++) {
                letras.append(nombreComppleto.charAt(i));
            }
            System.out.println(letras);
        } else {
            System.err.println("Error, el nombre no cumple el tamaño minimo de 5 caracteres");
        }
    }
}
