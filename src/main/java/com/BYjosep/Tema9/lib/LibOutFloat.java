package com.BYjosep.Tema9.lib;

import java.lang.reflect.Array;
import java.util.Random;

public class LibOutFloat {


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
     * @param array genera número aleatorio dentro de un {@link java.util.Arrays array} de
     *              n numeros de formato {@link Float float}
     */
    public static void generadorAleatorio(float[] array, float min, float max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = min + (max - min) * random.nextFloat();
        }
    }
}
