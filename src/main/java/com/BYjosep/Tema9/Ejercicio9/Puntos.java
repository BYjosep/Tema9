package com.BYjosep.Tema9.Ejercicio9;

public class Puntos {

    private final String nombre;
    private final int puntos;

    public Puntos(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return nombre + " - " + puntos + " puntos";
    }
}
