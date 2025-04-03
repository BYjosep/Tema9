package com.BYjosep.Tema9.ejemplos;

import java.util.HashSet;
import java.util.Set;

public class EjemploSet {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();
        System.out.println(numeros.add(1));

        System.out.println(numeros.add(2));
        System.out.println(numeros.add(3));
        System.out.println(numeros.add(4));
        System.out.println(numeros.add(4));

    }
}
