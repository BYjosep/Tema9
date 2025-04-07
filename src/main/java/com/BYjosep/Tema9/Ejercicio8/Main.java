package com.BYjosep.Tema9.Ejercicio8;

import com.BYjosep.Tema9.lib.Int.LibInInts;
import com.BYjosep.Tema9.lib.LibStrings;
import com.BYjosep.Tema9.lib.ANSI;

public class Main implements IDiccionario {
    private final Diccionario diccionario = new Diccionario();

    public static void main(String[] args) {
        new Main().ejecutar(); // 👈 Aquí lanzamos todo desde instancia
    }

    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = LibInInts.ingresarUnNumero("""
                ***********************
                * GESTIÓN DICCIONARIO *
                ***********************
                1. Añadir palabra
                2. Modificar palabra
                3. Eliminar palabra
                4. Consultar palabra
                5. Mostrar diccionario
                ---------------------
                0. Salir
                Elige una opción:
                """, 0, 5, "Opción fuera de rango");

            switch (opcion) {
                case 0 -> {
                    ANSI.printf("Saliendo del programa...", true, ANSI.Color.MAGENTA, ANSI.Color.NONE);
                    continuar = false;
                }
                case 1 -> anadirAlDiccionario();
                case 2 -> modificarEntrada();
                case 3 -> eliminarEntrada();
                case 4 -> consultarEntrada();
                case 5 -> diccionario.mostrarDiccionario();
            }
        }
    }

    @Override
    public void anadirAlDiccionario() {
        String palabra = LibStrings.ingresarTexto("Introduce palabra:");
        String definicion = LibStrings.ingresarTexto("Introduce definición:");
        if (diccionario.agregarPalabra(palabra, definicion)) {
            System.out.println("Palabra añadida con éxito.");
        } else {
            ANSI.printf("La palabra ya existe en el diccionario.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void modificarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a modificar:");
        if (diccionario.consultarPalabra(palabra) != null) {
            String nuevaDefinicion = LibStrings.ingresarTexto("Introduce nueva definición:");
            diccionario.modificarPalabra(palabra, nuevaDefinicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void eliminarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a eliminar:");
        if (diccionario.eliminarPalabra(palabra)) {
            System.out.println("Palabra eliminada.");
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void consultarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a consultar:");
        String definicion = diccionario.consultarPalabra(palabra);
        if (definicion != null) {
            System.out.println("Definición: " + definicion);
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }
}
