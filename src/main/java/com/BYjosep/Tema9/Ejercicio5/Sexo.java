package com.BYjosep.Tema9.Ejercicio5;

import com.BYjosep.Tema9.lib.LibRandoms;
import com.BYjosep.Tema9.lib.LibStrings;

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

        return Sexo.values()[LibRandoms.ran(0,Sexo.values().length)];
    }
}
