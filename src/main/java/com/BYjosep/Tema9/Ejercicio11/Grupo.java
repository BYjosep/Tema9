package com.BYjosep.Tema9.Ejercicio11;

import java.util.Objects;

class Grupo {
    private static int numeroGrupo = 0;
    private final int id;
    private final String nombre;
    private final Aula aula;

    public Grupo( String nombre, Aula aula) {
        this.id = ++numeroGrupo;
        this.nombre = nombre;
        this.aula = aula;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Aula getAula() { return aula; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return id == grupo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aula=" + aula +
                '}';
    }
}
