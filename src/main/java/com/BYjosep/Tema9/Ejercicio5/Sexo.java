package com.BYjosep.Tema9.Ejercicio5;

import java.util.Random;

public enum Sexo {
    MASCULINO("M"), FEMININO("F");


    private final String mensaje;

    Sexo(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje;
    }

    public Sexo random(){
        Random random = new Random();
        return Sexo.values()[random.nextInt(Sexo.values().length)];
    }
}
