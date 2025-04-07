package com.BYjosep.Tema9.Ejercicio6;

import com.BYjosep.Tema9.lib.ANSI;

import java.util.HashMap;
import java.util.Map;

public class Traductor {
    private final Map<String, String> diccionario = new HashMap<>();

    public boolean addTraduccion(String palabraValenciano, String palabraIngles) {
        if (palabraValenciano == null || palabraIngles == null ||
                palabraValenciano.isEmpty() || palabraIngles.isEmpty() ||
                diccionario.containsKey(palabraValenciano) ||
                diccionario.containsValue(palabraIngles)) {
            return false;
        }
        diccionario.put(palabraValenciano.toLowerCase(), palabraIngles.toLowerCase());
        return true;
    }

    public String getTraduccion(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return ANSI.format("La palabra no consta en el diccionario", false, ANSI.Color.YELLOW, ANSI.Color.NONE);
        }
        palabra = palabra.toLowerCase();
        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
            String val = entrada.getKey();
            String eng = entrada.getValue();

            if (val.equalsIgnoreCase(palabra)) return eng;
            if (eng.equalsIgnoreCase(palabra)) return val;
        }
        return ANSI.format("La palabra no existe.", false, ANSI.Color.YELLOW, ANSI.Color.NONE);
    }

    public Map<String, String> getDiccionario() {
        return diccionario;
    }
}
