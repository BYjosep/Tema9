package com.BYjosep.Tema9.Ejercicio11;

import java.util.Objects;

class Aula {
    private static int numAulas = 0;
    private final int id;
    private final double metrosCuadrados;

    public Aula(double metrosCuadrados) {
        this.id = ++numAulas;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getId() { return id; }
    public double getMetrosCuadrados() { return metrosCuadrados; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id == aula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}
