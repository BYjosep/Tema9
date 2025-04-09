package com.BYjosep.Tema9.Ejercicio11;

import java.util.Objects;

class Profesor {
    private String dni;
    private final String nombre;
    private double sueldo;

    public Profesor(String dni, String nombre, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }


    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(dni, profesor.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
