package com.BYjosep.Tema9.Ejercicio5;

import java.time.LocalDate;

public class Paciente  {

    private static int count = 0;
    private final int id;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final Sexo sexo;
    private float altura;
    private float peso;

    public Paciente(String nombre, LocalDate fechaNacimiento, Sexo sexo, float altura, float peso) {
        this.id = ++count;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

     void setAltura(float altura) {
        this.altura = altura;
    }

     void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
