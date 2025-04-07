package com.BYjosep.Tema9.Ejercicio9;

import com.BYjosep.Tema9.Ejercicio8.Diccionario;
import com.BYjosep.Tema9.lib.ANSI;
import com.BYjosep.Tema9.lib.Int.LibInInts;
import com.BYjosep.Tema9.lib.LibStrings;

import java.util.*;

public class Main implements IDiccionario2 {
    private final Diccionario diccionario = new Diccionario();
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private final List<Puntos> mejoresPuntuaciones = new ArrayList<>();

    public static void main(String[] args) {
        new Main().ejecutar();
    }

    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            switch (LibInInts.ingresarUnNumero("", 0, 7, "Opción fuera de rango")) {
                case 0 -> {
                    ANSI.printf("Saliendo del programa...", true, ANSI.Color.MAGENTA, ANSI.Color.NONE);
                    continuar = false;
                }
                case 1 -> anadirAlDiccionario();
                case 2 -> modificarEntrada();
                case 3 -> eliminarEntrada();
                case 4 -> consultarEntrada();
                case 5 -> diccionario.mostrarDiccionario();
                case 6 -> {
                    if (diccionario.size() != 0) {
                        int puntos = jugar();
                        ANSI.printf("Has conseguido %d punto%s.\n", true, ANSI.Color.CYAN, ANSI.Color.NONE, puntos, (puntos != 1 ? "s" : ""));
                        if (entraEnTop5(puntos)) {
                            String nombre = LibStrings.ingresarTexto("¡Has entrado en el TOP 5! Introduce tu nombre:");
                            guardarEnTop5(nombre, puntos);
                        }
                    }else {
                        ANSI.printf("No hay palabras en el diccionario para jugar.", true, ANSI.Color.RED, ANSI.Color.NONE);

                    }
                }
                case 7 -> System.out.println(MejoresPuntuaciones());
            }
            System.out.println("\n\n\n");
        }
    }

    static void mostrarMenu() {
        ANSI.clearScreen();

        ANSI.printf("""
        
             ██╗██╗   ██╗███████╗ ██████╗  ██████╗     ██████╗ ██╗ ██████╗ ██████╗██╗ ██████╗ ███╗   ██╗ █████╗ ██████╗ ██╗ ██████╗
             ██║██║   ██║██╔════╝██╔════╝ ██╔═══██╗    ██╔══██╗██║██╔════╝██╔════╝██║██╔═══██╗████╗  ██║██╔══██╗██╔══██╗██║██╔═══██╗
             ██║██║   ██║█████╗  ██║  ███╗██║   ██║    ██║  ██║██║██║     ██║     ██║██║   ██║██╔██╗ ██║███████║██████╔╝██║██║   ██║
        ██   ██║██║   ██║██╔══╝  ██║   ██║██║   ██║    ██║  ██║██║██║     ██║     ██║██║   ██║██║╚██╗██║██╔══██║██╔══██╗██║██║   ██║
        ╚█████╔╝╚██████╔╝███████╗╚██████╔╝╚██████╔╝    ██████╔╝██║╚██████╗╚██████╗██║╚██████╔╝██║ ╚████║██║  ██║██║  ██║██║╚██████╔╝
         ╚════╝  ╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝     ╚═════╝ ╚═╝ ╚═════╝ ╚═════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝
                                                                                                                                           
                
""", true, ANSI.Color.CYAN, ANSI.Color.NONE);

        ANSI.printf("""
                ╔════════════════════════════════════════════╗
                ║               MENÚ PRINCIPAL               ║
                ╠════════════════════════════════════════════╣
                ║ 1. Añadir palabra                          ║
                ║ 2. Modificar palabra                       ║
                ║ 3. Eliminar palabra                        ║
                ║ 4. Consultar palabra                       ║
                ║ 5. Mostrar diccionario                     ║
                ║ 6. Jugar                                   ║
                ║ 7. Mejores puntuaciones                    ║
                ╠════════════════════════════════════════════╣
                ║ 0. Salir                                   ║
                ╚════════════════════════════════════════════╝
""", true, ANSI.Color.GREEN, ANSI.Color.NONE);
    }

    @Override
    public void anadirAlDiccionario() {
        String palabra = LibStrings.ingresarTexto("Introduce palabra:");
        String definicion = LibStrings.ingresarTexto("Introduce definición:");
        if (diccionario.agregarPalabra(palabra, definicion)) {
            System.out.println("Palabra añadida con éxito.");
        } else {
            ANSI.printf("La palabra ya existe en el diccionario.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void modificarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a modificar:");
        if (diccionario.consultarPalabra(palabra) != null) {
            String nuevaDefinicion = LibStrings.ingresarTexto("Introduce nueva definición:");
            diccionario.modificarPalabra(palabra, nuevaDefinicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void eliminarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a eliminar:");
        if (diccionario.eliminarPalabra(palabra)) {
            System.out.println("Palabra eliminada.");
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public void consultarEntrada() {
        String palabra = LibStrings.ingresarTexto("Introduce la palabra a consultar:");
        String definicion = diccionario.consultarPalabra(palabra);
        if (definicion != null) {
            System.out.println("Definición: " + definicion);
        } else {
            ANSI.printf("La palabra no existe.", true, ANSI.Color.RED, ANSI.Color.NONE);
        }
    }

    @Override
    public int jugar() {
        int aciertos = 0;
        boolean seHaAcertado = true;
        String[] palabra;
        String texto;


        do {
            palabra = diccionario.obtenerPalabraPorIndice(rand.nextInt(diccionario.size()));
            System.out.println("Definición:");
            ANSI.printf(palabra[1] + "\n", false, ANSI.Color.GREEN, ANSI.Color.NONE);

            texto = scanner.nextLine().trim().toLowerCase();

            if (texto.equals(palabra[0].toLowerCase())) {
                aciertos++;
                ANSI.printf("¡Correcto!\n", true, ANSI.Color.YELLOW, ANSI.Color.NONE);
            } else {
                ANSI.printf("Incorrecto. La palabra era: " + palabra[0] + "\n", true, ANSI.Color.RED, ANSI.Color.NONE);
                seHaAcertado = false;
            }

        } while (seHaAcertado);

        return aciertos;
    }

    @Override
    public String MejoresPuntuaciones() {
        if (mejoresPuntuaciones.isEmpty()) {
            return "No hay puntuaciones aún.";
        }

        StringBuilder sb = new StringBuilder("🏆 Mejores puntuaciones:\n");
        int i = 1;
        for (Puntos p : mejoresPuntuaciones) {
            sb.append(String.format("%d. %s - %d puntos\n", i++, p.getNombre(), p.getPuntos()));
        }
        return sb.toString();
    }

    private boolean entraEnTop5(int nuevaPuntuacion) {
        if (mejoresPuntuaciones.size() < 5) return true;
        return mejoresPuntuaciones.stream().anyMatch(p -> nuevaPuntuacion > p.getPuntos());
    }

    private void guardarEnTop5(String nombre, int puntos) {
        mejoresPuntuaciones.add(new Puntos(nombre, puntos));
        mejoresPuntuaciones.sort((a, b) -> Integer.compare(b.getPuntos(), a.getPuntos()));
        if (mejoresPuntuaciones.size() > 5) {
            mejoresPuntuaciones.remove(5);
        }
    }
}
