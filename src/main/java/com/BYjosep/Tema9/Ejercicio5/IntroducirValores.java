package com.BYjosep.Tema9.Ejercicio5;

import com.BYjosep.Tema9.lib.LibChars;
import com.BYjosep.Tema9.lib.LibDate;
import com.BYjosep.Tema9.lib.LibRandoms;
import com.BYjosep.Tema9.lib.LibStrings;

import java.time.LocalDate;

public class IntroducirValores {
    public String GenerarNombre() {
        return LibStrings.generarTextoAlatorio(20,'a', 'Z');
    }

    public static Sexo introducirSexo() {
        char[] caracteresPermitidos = new char[]{'M', 'F'};
        char sexo = LibChars.ingresarUnCaracter("Ingresa el sexo (M/F) :", caracteresPermitidos, "Las respuestas permitidas son: M/F\n");

        if (sexo == 'M') {
            return Sexo.MASCULINO;
        } else if (sexo == 'F') {
            return Sexo.FEMININO;
        }
        return Sexo.MASCULINO;

    }

    public static LocalDate IntroducirFecha() {
        return LibDate.IngresarFecha();
    }


}
