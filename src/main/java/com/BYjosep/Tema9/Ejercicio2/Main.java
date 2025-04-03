package com.BYjosep.Tema9.Ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        int capacidad = random.nextInt(10,101);
        ArrayListEstadisticas listaEstadisticas = new ArrayListEstadisticas(capacidad);

        generarDatos(listaEstadisticas, capacidad);

        System.out.println("            Estadisticas");
        System.out.println("Minimo: " + listaEstadisticas.minimo());
        System.out.println("Maximo: " + listaEstadisticas.maximo());
        System.out.println("Suma: "+ listaEstadisticas.sumatorio());
        System.out.println("Media: "+ listaEstadisticas.media());
        System.out.println("Moda: "+ listaEstadisticas.moda());
    }

    private static void generarDatos(ArrayListEstadisticas listaEstadisticas,int size){
        for (int i = 0; i < size; i++) {
            listaEstadisticas.add(random.nextDouble(0,100));
        }
    }
}
