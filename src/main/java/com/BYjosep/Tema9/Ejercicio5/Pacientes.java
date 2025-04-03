package com.BYjosep.Tema9.Ejercicio5;

import java.util.*;

public class Pacientes extends ArrayList implements IPacientes {
    private List<Paciente> pacientes;


    public Pacientes() {
        pacientes = new ArrayList<>();
    }

    @Override
    public int[] menorMayor() {
        int[] array = new int[2];

        return array;
    }

    @Override
    public int[] pacientesPorSexo() {
        int[] array = new int[2];

        return array;
    }

    @Override
    public double calcularIMC() {
        return 0;
    }

    @Override
    public int optenerEdad() {

        return 0;
    }

    @Override
    public IMC getIMC() {

        return null;
    }
}
