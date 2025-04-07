package com.BYjosep.Tema9.Ejercicio4;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        System.out.println("Is empty: " + cola.isEmpty());


        ponerValoresEnCola(cola);

        System.out.println("Is empty: " + cola.isEmpty());
        System.out.println("Size: " + cola.size());
        System.out.println("Peek: " + cola.peek());
        System.out.println("Remove:" + cola.remove());
        System.out.println("Remove:" + cola.remove());
        System.out.println("Cola: " + cola);
        cola.reverse3();
        System.out.println("Reverse: " + cola);
    }

    private static void ponerValoresEnCola(Cola<String> Cola) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < random.nextInt(2, 20); i++) {

            for (int j = 0; j < random.nextInt(1, 50); j++) {
                builder.append((char) random.nextInt(1, 100));
            }
            Cola.add(builder.toString());
            builder.delete(0, builder.length());
        }
    }
}
