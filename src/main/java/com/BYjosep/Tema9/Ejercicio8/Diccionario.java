package com.BYjosep.Tema9.Ejercicio8;

import com.BYjosep.Tema9.lib.LibStrings;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    private final Map<String, String> palabras;

    public Diccionario() {
        palabras = new HashMap<>();
    }

    public boolean agregarPalabra(String palabra, String definicion) {
        palabra = palabra.toLowerCase();
        if (palabras.containsKey(palabra)) {
            return false;
        }
        palabras.put(palabra, definicion);
        return true;
    }

    public boolean modificarPalabra(String palabra, String nuevaDefinicion) {
        palabra = palabra.toLowerCase();
        if (!palabras.containsKey(palabra)) {
            return false;
        }
        palabras.put(palabra, nuevaDefinicion);
        return true;
    }

    public boolean eliminarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        return palabras.remove(palabra) != null;
    }

    public String consultarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        return palabras.get(palabra);
    }

    public void mostrarDiccionario() {
        if (palabras.isEmpty()) {
            System.out.println("El diccionario está vacío.");
        } else {
            System.out.println("Diccionario completo:");
            palabras.forEach((clave, valor) -> System.out.println("- " + clave + ": " + valor));
        }
    }
}