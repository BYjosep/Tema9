package com.BYjosep.Tema9.lib;

import java.lang.reflect.Array;
import java.util.Scanner;


public class LibDoubles {

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
     * @return Devuelve la frase ingresada en formato {@link Double double}
     */
    public static Double ingresarUnNumeroD(String texto) {
        System.out.println(texto);

        return Double.parseDouble(scanner.nextLine());

    }


    /**
     * Ingresar text.
     * Recuerde cerrar {@link Scanner Scanner} con el metodo cerrarScaner
     * (Echo para no tener que estar escribiendo este codigo en cada ejercicio)
     *
     * @return Devuelve la frase ingresada en formato {@link Double double}
     */
    public static Double ingresarUnNumeroD(String texto, double min, double max) {
        double num ;
        boolean valido = false;
        do {
            System.out.println(texto);
            try {
                num = Double.parseDouble(scanner.nextLine());
                if (num > min && num < max) {
                    valido = true;
                }else {
                    ANSI.printf("El rango de numeros permitidos es "+ min+", "+max,false, ANSI.Color.RED,ANSI.Color.NONE);
                }
            }catch (NumberFormatException e) {
                ANSI.printf("Solo ingresar numeros",false, ANSI.Color.RED,ANSI.Color.NONE);
                num = 0;
            }
        }while (!valido);

        return num;

    }


    /* **********************
     *********  out  ********
     ************************ */

    /**
     * Ingrese un {@link  Array array} para calcular la media
     *
     * @param numeros Ingresa el {@link  Array array}
     * @return Devuelve {@link Double double}
     */
    public static double mediaDeNumerosEnArray(double[] numeros) {
        double suma = 0;
        for (double numero : numeros) {
            suma = suma + numero;
        }
        return suma / numeros.length;
    }


    /**
     * Ingrese un {@link  Array array} para calcular la media
     *
     * @param min     El valor minimo desde el que hace la media
     * @param numeros Ingresa el {@link  Array array}
     * @return Devuelve {@link Double double}
     */
    public static double mediaDeNumerosEnArray(double[] numeros, int min) {
        double suma = 0;
        double contador = 0;
        for (double numero : numeros) {
            if (numero > min) {
                suma = suma + numero;
                contador++;
            }
        }
        return suma / contador;
    }




}
