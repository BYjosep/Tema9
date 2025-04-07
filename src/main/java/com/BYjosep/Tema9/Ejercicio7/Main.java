package com.BYjosep.Tema9.Ejercicio7;

import com.BYjosep.Tema9.lib.ANSI;
import com.BYjosep.Tema9.lib.LibDoubles;
import com.BYjosep.Tema9.lib.LibStrings;
import com.BYjosep.Tema9.lib.Int.LibInInts;

public class  Main {
    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        boolean continuar = true;

        while (continuar) {

            int opcion = LibInInts.ingresarUnNumero("""
                ╔════════════════════════════════════════════════════════╗
                ║              CONVERSOR DE MONEDAS (EUR)                ║
                ╠════════════════════════════════════════════════════════╣
                ║  1. Mostrar monedas disponibles                        ║
                ║  2. Convertir de EUR a otra moneda                     ║
                ║  0. Salir del programa                                 ║
                ╚════════════════════════════════════════════════════════╝
                Por favor, elige una opción: """, 0, 2, "Opción fuera de rango. Intenta nuevamente.");

            switch (opcion) {
                case 0 -> {
                    ANSI.printf("Gracias por usar el conversor. ¡Hasta pronto!",true, ANSI.Color.MAGENTA, ANSI.Color.NONE);
                    continuar = false;
                }
                case 1 -> mostrarMonedas(conversor);
                case 2 -> convertirMoneda(conversor);
                default -> System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }



    private static void mostrarMonedas(ConversorMonedas conversor) {
        System.out.println("\nMonedas disponibles:");
        conversor.getMonedas().forEach((k, v) -> System.out.printf(" - %s: %s%n", k, v));
    }

    private static void convertirMoneda(ConversorMonedas conversor) {
        double cantidadEuros = LibDoubles.ingresarUnNumeroD("Introduce la cantidad en euros:", 0.01, 100000);
        mostrarMonedas(conversor);

        String codigo = LibStrings.ingresarTexto("Introduce el código de la moneda a la que quieres convertir:").toUpperCase();

        if (!conversor.getMonedas().containsKey(codigo)) {
            ANSI.printf("Código de moneda no válido. Inténtalo de nuevo.",true, ANSI.Color.RED, ANSI.Color.NONE);

            return;
        }

        System.out.println("\n" + conversor.convertir(cantidadEuros, codigo) + "\n");
    }
}
