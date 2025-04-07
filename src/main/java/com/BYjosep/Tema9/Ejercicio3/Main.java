package com.BYjosep.Tema9.Ejercicio3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();
        System.out.println("Pila is empty: " + pila.isEmpty());
        ponerValoresEnPila(pila);
        System.out.println("Pila is empty: " + pila.isEmpty());
        System.out.println("Size de pila: " + pila.size());
        System.out.println("Top: " + pila.top());
        System.out.println("Pop: " + pila.pop());
        System.out.println("Pop: " + pila.pop());
        System.out.println(pila);

    }

    private static void ponerValoresEnPila(Pila<String> pila) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < random.nextInt(2, 20); i++) {

            for (int j = 0; j < random.nextInt(1, 50); j++) {
                builder.append((char) random.nextInt(1, 100));
            }
            pila.push(builder.toString());
            builder.delete(0, builder.length());
        }
    }
}
