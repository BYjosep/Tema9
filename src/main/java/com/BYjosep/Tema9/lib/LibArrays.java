package com.BYjosep.Tema9.lib;

import com.BYjosep.Tema9.lib.Int.LibOutInts;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
//
public class LibArrays {


    /**
     * @param numeros {@link  Array array} que desea modificar
     */
    public static void introducirNumerosEnArray(float[] numeros) {
        //float numero;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = LibFloats.ingresarUnNumeroF("Ingresa un numero");
        }
    }


    /* ********************************************
     * ** Ingresar parametros dentro de un array **
     * ********************************************
     */

    /**
     * Ingresar caracteres en un array
     *
     * @param caracteres {@link  Array array} que desea modificar
     */
    public static void introducirCaracterEnArray(char[] caracteres) {
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = LibChars.ingresarUnCaracter("Ingresa un caracter");
        }
    }


    /**
     * Ingresar caracteres en un array
     *
     * @param numeroEntero {@link  Array array} que desea modificar
     */
    public static void introducirIntEnArray(int[] numeroEntero) {
        for (int i = 0; i < numeroEntero.length; i++) {
            numeroEntero[i] = LibChars.ingresarUnCaracter("Ingresa un caracter");
        }
    }


    /**
     * Ingresar numeroFloat en un array
     *
     * @param numeroFloat {@link  Array array} que desea modificar
     */
    public static void introducirFloatEnArray(float[] numeroFloat) {

        for (int i = 0; i < numeroFloat.length; i++) {
            numeroFloat[i] = LibFloats.ingresarUnNumeroF("Ingresa un numero float");
        }
    }


    /**
     * Ingresar texto en un array
     *
     * @param texto {@link  Array array} que desea modificar
     */
    public static void introducirTexto(String[] texto) {

        for (int i = 0; i < texto.length; i++) {
            texto[i] = LibStrings.ingresarTexto("Ingresa un texto");
        }
    }


    /**
     * @param array genera número aleatorio dentro de un {@link Arrays array} de
     *              n numeros de formato {@link Double double}
     */
    public static void generadorAleatorio(double[] array, double min, double max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = min + (max - min) * random.nextDouble();
        }
    }


    /**
     * @param array genera o cambial los valores de un array con
     *              una capacidad ya definida
     */
    public static void insertarValorEnArray(int[] array) {
        LibOutInts.generadorAleatorio(array, 0, 50);
    }

    /**
     * @param array visualiza el array
     */
    public static void visualizarArray(int[] array) {
        String arrayStr = Arrays.toString(array);
        System.out.println(arrayStr);
    }


    /* **************************
     *                        *
     *                        *
     *************************** */


    /**
     * Ingrese un {@link  Array array} para calcular la media
     *
     * @param numeros Ingresa el {@link  Array array}
     * @return Devuelve {@link Float float}
     */
    public static float mediaDeNumerosEnArray(float[] numeros) {
        float suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }
        return suma / numeros.length;
    }


    /**
     * @param caracteres Ingresa el {@link Array array} de tipo {@link Character char}
     * @return Devuelve un {@link String String} con la cadena de caracteres
     * con las posiciones impares suponiendo que la posicion inicial es 0
     */
    public static String repetirCaracterImparDeArray(char[] caracteres) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < caracteres.length; i++) {
            if (i % 2 != 0) {
                cadena.append(caracteres[i]);
                cadena.append(caracteres[i]);
            } else {
                cadena.append(caracteres[i]);
            }
        }
        return cadena.toString();
    }


    /**
     * @param numeros array que desea crear una tabla de 4x(n)columnas
     *                este {@link Array array} es de tipo {@link Float float}
     * @return devuelve un {@link String String} con la cadena de caracteres
     */
    public static String tablaDeNumeros(float[] numeros) {
        int inicio = 0;
        int aux = 4;
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = inicio; i < aux; i++) {
                sb.append(numeros[i]).append(" ");
            }
            sb.append("\n");
            inicio = aux;
            aux += 4;
        } while (numeros.length != inicio);
        return sb.toString();
    }

    /**
     * @param array visualiza las posiciones pares asumiendo de que la primera
     *              posicion es 0
     */
    public static void visualizarPares(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j : array) {
            if (j % 2 == 0)
                sb.append(j).append(",");
        }
        String arrayStr = LibStrBuild.formatearArray(sb);
        System.out.println(arrayStr);
    }

    /**
     * @param array visualiza los multiplos de 3
     */
    public static void visualizarMultiplos3(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0)
                sb.append("En la posicion ").append(i).append(" esta el numero; ").append(array[i]).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * @param arrau array que desea copiar
     * @return devuelve él un array modificado mostrando los
     * valores iguales o menores a 10 como -1
     */
    public static int[] mayorA10(int[] arrau) {
        int[] arrayAux = new int[arrau.length];
        for (int i = 0; i < arrau.length; i++) {
            if (arrau[i] <= 10) {
                arrayAux[i] = -1;
            } else {
                arrayAux[i] = arrau[i];
            }
        }
        return arrayAux;
    }


    /**
     * @param array array de tipo {@link Integer int}
     * @return devuelve el array invertido
     */
    public static int[] invertirOrdenDeArray(int[] array) {
        if (array == null) {
            return null;
        }
        int cantidad = array.length - 1;
        int[] retorno = new int[array.length];
        for (int i : array) {
            retorno[cantidad] = i;
            cantidad--;
        }
        return retorno;
    }


    /**
     * @param array array que deseausar
     * @return retorna un array que retorna un array que
     * suma exponencialmente
     */
    public static int[] sumaDeNumeros(int[] array) {
        if (array == null) {
            return null;
        }
        int[] suma = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                suma[i] = array[i];
            } else {
                suma[i] = array[i] + suma[i - 1];
            }
        }
        return suma;
    }


    /**
     * @param array array que desea comprobar
     * @return Devuelve array con los numeros pares en caso de que exista
     */
    public static int[] paresDeArrayEnArray(int[] array) {
        int catidadPares = pares(array);
        if (catidadPares == 0) {
            return null;
        }
        int[] p = new int[catidadPares];
        int posicion = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                p[posicion] = i;
                posicion++;
            }
        }
        return p;
    }


    /**
     * @param array array del que desea contar los pares
     * @return devuelve un {@link Integer int} con el numero de pares
     */
    public static int pares(int[] array) {
        if (array == null) {
            return 0;
        }
        int pares = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }
}
