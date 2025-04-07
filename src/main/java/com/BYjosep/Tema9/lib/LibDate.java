package com.BYjosep.Tema9.lib;

import com.BYjosep.Tema9.lib.Int.LibInInts;

import java.time.LocalDate;


public class LibDate {

    public static LocalDate IngresarFecha(){

        LocalDate fecha, localDate = LocalDate.now();
        int anoActual = localDate.getYear();
        int dia=-1, mes, ano;
        do {
            try {

                mes= LibInInts.ingresarUnNumero("Ingresa el mes:"
                        ,1,12);

                switch (mes){

                    case 1,3,5,7,8,10,12->dia=LibInInts.ingresarUnNumero("Ingresa el dia:",1,31);

                    case 2->dia=LibInInts.ingresarUnNumero("Ingresa el dia:",1,28);

                    case 4,6,9,11->dia=LibInInts.ingresarUnNumero("Ingresa el dia:",1,30);

                    default -> System.err.println("Aquí no debe de llegar");
                }
                ano = LibInInts.ingresarUnNumero("Ingresa el año:", 1800, anoActual);


                break;
            }catch (NumberFormatException nfe){
                System.err.println("solo numeros:");
            }

        }while (true);
        fecha = LocalDate.of(ano,mes,dia);
        return fecha;
    }
}
