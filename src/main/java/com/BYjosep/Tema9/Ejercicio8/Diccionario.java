package com.BYjosep.Tema9.Ejercicio8;


import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    private final Map<String, String> palabras;
    private int size;

    public Diccionario() {
        palabras = new HashMap<>();
        size = 0;
    }

    public boolean agregarPalabra(String palabra, String definicion) {
        palabra = palabra.toLowerCase();
        if (palabras.containsKey(palabra)) {
            return false;
        }
        palabras.put(palabra, definicion);
        size++;
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
        size--;
        return palabras.remove(palabra) != null;
    }

    public String consultarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        return palabras.get(palabra);
    }

    public int size() {
        return size;
    }

    public String[] obtenerPalabraPorIndice(int indice) {

        String[] par = new String[2];
        if (indice < 0 || indice >= palabras.size()) {
            return null; // índice fuera de rango
        }
        String clave = palabras.keySet().stream().toList().get(indice);
        par[0] = clave;
        par[1] = palabras.get(clave);

        return par;
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