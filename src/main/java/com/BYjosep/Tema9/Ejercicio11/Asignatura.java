package com.BYjosep.Tema9.Ejercicio11;

import java.util.Objects;

class Asignatura {
    private static int numeroAsignatura = 0;
    private int id;
    private String nombre;
    private Profesor profesor;

    public Asignatura( String nombre, Profesor profesor) {
        this.id = ++numeroAsignatura;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
