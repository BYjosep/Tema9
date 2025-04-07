package com.BYjosep.Tema9.lib;

import java.util.Scanner;

public class LibFloats {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * cerrar {@link Scanner Scanner}
     */
    public static void cerrarScaner() {
        scanner.close();
    }

    /* **********************
     *********  in  *********
     ************************ */

    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Character char}
     */
    public static float ingresarUnNumeroF(String texto) {
        System.out.println(texto);

        return Float.parseFloat(scanner.nextLine());

    }


    /**
     * Ingresar un número con un valor minimo.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Float float}
     */
    public static float ingresarUnNumeroF(String texto, float min) {
        float numero;
        do {
            System.out.println(texto);
            numero = Float.parseFloat(scanner.nextLine());

        } while (numero < min);


        return numero;

    }


    /**
     * Ingresar número con valor minimo y maximo.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Float float}
     */
    public static float ingresarUnNumeroF(String texto, float min, float max) {
        float numero;

        do {
            System.out.println(texto);
            numero = Float.parseFloat(scanner.nextLine());
        } while (numero < min && numero > max);

        return numero;
    }



    /**
     * Ingresar número con valor minimo y maximo.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Float float}
     */
    public static float ingresarUnNumeroF(String texto, float min, float max, String mensajeError) {
        float numero;
        boolean valido = false;

        do {
            System.out.println(texto);
            numero = Float.parseFloat(scanner.nextLine());
            if (numero < min && numero > max) {
                System.out.println(mensajeError);
            }else {
                valido = true;
            }
        } while (!valido);

        return numero;
    }
}
