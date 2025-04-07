package com.BYjosep.Tema9.Ejercicio5;


import com.BYjosep.Tema9.lib.LibRandoms;
import com.BYjosep.Tema9.lib.LibStrings;

import java.time.LocalDate;
import java.util.Random;

public class Generator {

    /**
     * Genera un valor aleatorio del enumerado Sexo.
     *
     * @return una instancia aleatoria de Sexo
     */
    public static Sexo generarSexo() {
        Random random = new Random();
        return Sexo.values()[random.nextInt(Sexo.values().length)];
    }

    /**
     * Genera un nombre aleatorio utilizando caracteres desde 'A' hasta 'z' con una longitud de 20.
     *
     * @return una cadena de texto aleatoria
     */
    public static String generarNombre() {
        return LibStrings.generarTextoAlatorio(20,'A', 'z');
    }

    /**
     * Genera una fecha aleatoria restando días, meses y años desde la fecha actual.
     * Se asegura de que la fecha generada sea válida.
     *
     * @return una fecha aleatoria anterior a la actual
     */
    public static LocalDate generarFecha() {
        LocalDate fecha = LocalDate.now();
        boolean fechaValida = false;

        while (!fechaValida) {
            try {
                fecha.minusDays(LibRandoms.ran(1,12)).minusMonths(LibRandoms.ran(1,10)).minusYears(LibRandoms.ran(1,100));
                fechaValida = true;
            } catch (Exception _) {}
        }

        return fecha;
    }

    /**
     * Genera una altura aleatoria entre 0.1 y 2 metros.
     *
     * @return un valor flotante representando la altura
     */
    public static float generarAltura() {
        return LibRandoms.ran(0.1f,2f);
    }

    /**
     * Genera un peso aleatorio entre 0.1 y 400 kilogramos.
     *
     * @return un valor flotante representando el peso
     */
    public static float generarPeso() {
        return LibRandoms.ran(0.1f,400f);
    }
}
