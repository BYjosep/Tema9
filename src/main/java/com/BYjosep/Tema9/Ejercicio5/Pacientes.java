package com.BYjosep.Tema9.Ejercicio5;

import com.BYjosep.Tema9.lib.ANSI;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una colección de objetos {@link Paciente}.
 * Proporciona métodos para agregar pacientes, calcular edades extrema y
 * contar pacientes por sexo.
 */
public class Pacientes extends ArrayList {
    private final List<Paciente> pacientes;

    public Pacientes() {
        pacientes = new ArrayList<>();
    }

    /**
     * Añade un nuevo paciente a la lista.
     *
     * @param paciente el paciente que se desea añadir
     * @return {@code true} si el paciente fue añadido correctamente
     */
    public boolean add(Paciente paciente) {
        return pacientes.add(paciente);
    }

    /**
     * Obtiene la edad mínima y máxima entre todos los pacientes.
     *
     * @return un arreglo de dos enteros, donde el índice 0 es la edad mínima
     *         y el índice 1 es la edad máxima
     */
    public int[] menorMayor() {
        int[] array = new int[2];
        int menor = 1000, mayor = -1;
        for (Paciente paciente : pacientes) {
            if (paciente.getEdad() > mayor) {
                mayor = paciente.getEdad();
                array[1] = mayor;
            }
            if (paciente.getEdad() < menor) {
                menor = paciente.getEdad();
                array[0] = menor;
            }
        }
        return array;
    }

    /**
     * Cuenta cuántos pacientes hay por sexo (masculino y femenino).
     * Si se encuentra algún sexo no identificado, se muestra una advertencia por consola.
     *
     * @return un arreglo de dos enteros, donde el índice 0 representa la cantidad de pacientes masculinos
     *         y el índice 1 la de pacientes femeninos
     */
    public int[] pacientesPorSexo() {
        int[] array = new int[2];
        int contadorMasculinos = 0, contadorFemininos = 0, contadorSexoNoIdentificado = 0;
        for (Paciente paciente : pacientes) {
            switch (paciente.getSexo()) {
                case MASCULINO -> contadorMasculinos++;
                case FEMININO -> contadorFemininos++;
                default -> contadorSexoNoIdentificado++;
            }
        }
        if (contadorSexoNoIdentificado > 0) {
            ANSI.printf("Se han encontrado " + contadorSexoNoIdentificado + " pacientes con sexo no identificado",
                    false, ANSI.Color.YELLOW, ANSI.Color.NONE);
        }
        array[0] = contadorMasculinos;
        array[1] = contadorFemininos;

        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : pacientes) {
            sb.append(paciente).append("\n");
        }
        return sb.toString();
    }
}
