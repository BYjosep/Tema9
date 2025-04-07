package com.BYjosep.Tema9.lib;

import java.util.Random;
import java.util.Scanner;

public class LibStrings {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * cerrar {@link Scanner Scanner}
     */
    public static void cerrarScaner() {
        scanner.close();
    }

    /**
     * Ingresar frase
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link String String}
     */
    public static String ingresarFrase() {
        String frase;
        System.out.println("Ingrese una frase");
        frase = scanner.nextLine();
        return frase;
    }

    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link String String}
     */
    public static String ingresarTexto(String texto) {
        String palabra;

        System.out.println(texto);
        palabra = scanner.nextLine();

        return palabra;
    }

    /**
     * Metodo para generar textos
     * @param maximoDeCaracteres Número de caracteres maximos a generar
     * @param caracterMinimo caracter desde el que puede generar.
     * @param caracterMaximo caracter hasta el que genera.
     * @return Devuelve un {@link String con la cadena de caracteres deseada}
     * @throws IllegalArgumentException Esto se puede deber a que el caracter minimo es superior al maximo
     */
    public static String generarTextoAlatorio(int maximoDeCaracteres,char caracterMinimo, char caracterMaximo ) throws IllegalArgumentException{
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < random.nextInt(1, maximoDeCaracteres+1); j++) {
            try {
                builder.append((char) random.nextInt(caracterMinimo, caracterMaximo+1));

            }catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException(iae.getCause()+"\nLos campos no estan bien colocados");
            }
        }
        return builder.toString();
    }
}
