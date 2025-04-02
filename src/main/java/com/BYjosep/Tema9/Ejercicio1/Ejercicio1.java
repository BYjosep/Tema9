package com.BYjosep.Tema9.Ejercicio1;

import java.util.ArrayList;


public class Ejercicio1 {

    public static ArrayList arrayToArrayList(int[] array) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int numero : array) {
            if (numero % 2 == 0) {
                lista.add(numero);
            }
        }
        for (int numero : array) {
            if (numero % 2 != 0) {
                lista.add(numero);
            }
        }

        return lista;
    }

}
