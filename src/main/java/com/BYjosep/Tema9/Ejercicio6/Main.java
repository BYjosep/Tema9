package com.BYjosep.Tema9.Ejercicio6;

import com.BYjosep.Tema9.lib.ANSI;
import com.BYjosep.Tema9.lib.Int.LibInInts;
import com.BYjosep.Tema9.lib.LibStrings;

public class Main {
    private static Traductor traductor = new Traductor();

    public static void main(String[] args) {

        boolean continuar = true;
        while (continuar) {
            switch (menu()) {
                case 0-> {
                    ANSI.clearScreen();
                    ANSI.printf("SALIENDO",true, ANSI.Color.BLUE, ANSI.Color.NONE);
                    continuar = false;
                }
                case 1->{
                    ANSI.clearScreen();
                    ingresarTraducciones();
                }
                case 2->{
                    ANSI.clearScreen();
                    System.out.println(hacerTraduccion());

                }

                default -> {

                }
            }

        }
    }

    private static int menu(){
        return LibInInts.ingresarUnNumero("""
                ╔═════════════════════════════════════════╗
                ║             MENÚ PRINCIPAL              ║
                ╠═════════════════════════════════════════╣
                ║  1. Introducir parejas de palabras      ║
                ║  2. Traducir palabras                   ║
                ║  0. Salir de la aplicación              ║
                ╚═════════════════════════════════════════╝
                            
                Elige una opción:
                
                """) ;
    }

    private static void ingresarTraducciones(){
        String palabraEnValenciano, palabraEnIngles;
        boolean existePalabra;
        int repeticiones=LibInInts.ingresarUnNumero("Cuantas entradas desea ingresar maximo 100 entradas a la vez",
                1,100,"ha ingresado un valor que no esta dentro del rango");
        for (int i = 0; i < repeticiones; i++) {

            palabraEnValenciano = LibStrings.ingresarTexto("Ingresa la parabra en valenciano");
            palabraEnIngles = LibStrings.ingresarTexto("Ingresa la parabra en ingles");

            existePalabra= traductor.addTraduccion(palabraEnValenciano,palabraEnIngles);
            if(!existePalabra) {
                ANSI.printf("La palabra ya existe\n",false, ANSI.Color.RED, ANSI.Color.NONE);
                --i;
            }

            System.out.println("\n\n");

        }
    }

    private static String hacerTraduccion(){
        String palabra = LibStrings.ingresarTexto("Ingresa la palabra a traducir");
        return traductor.getTraduccion(palabra);
    }

}
