package com.BYjosep.Tema9.Ejercicio5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Paciente {

    private static int count = 0;
    private final int id;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final Sexo sexo;
    private float altura;
    private float peso;
    private double imc;

    public Paciente(String nombre, LocalDate fechaNacimiento, Sexo sexo, float altura, float peso) {
        this.id = ++count;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.imc = calcularIMC();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) del paciente.
     *
     * @return el valor del IMC
     */
    public double calcularIMC() {
        double imc = this.peso / (this.altura * this.altura);
        this.imc = imc;
        return imc;
    }

    /**
     * Calcula la edad actual del paciente en años.
     *
     * @return edad en años
     * @throws DateTimeException si la fecha de nacimiento es nula o futura
     */
    public int getEdad() {
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new DateTimeException("La fecha de nacimiento no existe o es superior a la fecha actual");
        }
        int edad;
        edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        return edad;
    }

    /**
     * Determina la categoría de IMC del paciente según el valor calculado.
     *
     * @return el valor del enumerado {@link IMC} correspondiente al rango del IMC
     * @throws VerifyError si el valor del IMC no se encuentra en los rangos definidos
     */
    public IMC getIMC() throws VerifyError {
        double imc = calcularIMC();

        if (imc < 18.5) {
            return IMC.PESO_INSUFICIENTE;
        }
        if (imc >= 18.5 && imc < 25) {
            return IMC.PESO_NORMAL;
        }
        if (imc >= 25 && imc < 27) {
            return IMC.SOBREPESO_GRADO_1;
        }
        if (imc >= 27 && imc < 30) {
            return IMC.SOBREPESO_GRADO_2;
        }
        if (imc >= 30) {
            return IMC.SOBREPESO_GRADO_3;
        }

        throw new VerifyError("El imc no es válido");
    }


    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return id == paciente.id && Float.compare(altura, paciente.altura) == 0 && Float.compare(peso, paciente.peso) == 0 && Double.compare(imc, paciente.imc) == 0 && Objects.equals(nombre, paciente.nombre) && Objects.equals(fechaNacimiento, paciente.fechaNacimiento) && sexo == paciente.sexo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaNacimiento, sexo, altura, peso, imc);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                " id= " + id +
                ", nombre= " + nombre +
                ", edad= " + getEdad() +
                ", sexo= " + sexo +
                ", altura= " + altura +
                ", peso= " + peso +
                ", imc= " + imc +
                " }";
    }
}
