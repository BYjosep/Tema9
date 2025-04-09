package com.BYjosep.Tema9.Ejercicio11;

import java.util.*;

class Alumno {
    private static int idAAsignar= 0;
    private final int id;
    private final String nombre;
    private final Grupo grupo;
    private final Set<Asignatura> asignaturas;

    public Alumno( String nombre, Grupo grupo) {
        this.id = ++idAAsignar;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = new LinkedHashSet<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Grupo getGrupo() { return grupo; }
    public Set<Asignatura> getAsignaturas() { return asignaturas; }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}';
    }
}