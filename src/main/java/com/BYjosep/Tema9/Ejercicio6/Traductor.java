package com.BYjosep.Tema9.Ejercicio6;

import com.BYjosep.Tema9.lib.ANSI;

import java.util.HashMap;
import java.util.Map;

public class Traductor extends HashMap<String,String> {
    private Map<String,String> diccionario;
    public Traductor() {
        diccionario = new HashMap<>();
    }
    public boolean addTraduccion(String palabraValenciano, String palabraIngles) {
        if (diccionario.containsKey(palabraValenciano) || diccionario.containsValue(palabraIngles)|| palabraValenciano.isEmpty() || palabraIngles.isEmpty()) {
            return false;
        }
        diccionario.put(palabraValenciano,palabraIngles);
        return true;
    }

    public boolean setTraduccion(String palabraValenciano, String palabraIngles) {
        if (!diccionario.containsKey(palabraValenciano) || diccionario.containsValue(palabraIngles)) {
            return false;
        }
        diccionario.put(palabraValenciano,palabraIngles);
        return true;
    }

    public String getTraduccion(String palabra) {
        if (!diccionario.containsKey(palabra)|| !diccionario.containsValue(palabra) || palabra.isEmpty()) {
        return ANSI.format("La palabra no consta en el diccionario",false, ANSI.Color.YELLOW, ANSI.Color.NONE);
        }

        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
            String clave = entrada.getKey();
            String valor = entrada.getValue();

            if (clave.contains(palabra) &&  valor.contains(palabra)) {
                return "La palabra es igual en ambos idiomas";
            }
            if (clave.contains(palabra)) {

                return valor;
            }
            if (valor.contains(palabra)) {

                return clave;
            }
        }
        return "Palabra no encontrada en el diccionario";
    }
}
