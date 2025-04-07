package com.BYjosep.Tema9.Ejercicio1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] numeros = new int[]{47, 14, 28, 10, 33, 15, 26, 7, 8, 28};
        int[] numeros2 = new int[10];

        System.out.println(Ejercicio1.arrayToArrayList(numeros));

        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = random.nextInt(0, 51);
        }

        System.out.println(Ejercicio1.arrayToArrayList(numeros2));
    }
}
