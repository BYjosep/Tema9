package com.BYjosep.Tema9.Ejercicio5;

import com.BYjosep.Tema9.lib.Int.LibInInts;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pacientes pacientes = new Pacientes();
        int minimoPacientes = 1, maximoPacientes = 1000;

        int cuantosPacientes = LibInInts.ingresarUnNumero(
                "Cuántos pacientes desea generar entre " + minimoPacientes + " y " + maximoPacientes + ":",
                minimoPacientes,
                maximoPacientes
        );

        for (int i = 0; i < cuantosPacientes; i++) {
            Paciente paciente = new Paciente(
                    Generator.generarNombre(),
                    Generator.generarFecha(),
                    Generator.generarSexo(),
                    Generator.generarAltura(),
                    Generator.generarPeso()
            );
            pacientes.add(paciente);
        }

        mostrarPacientes(pacientes);
        mostrarEstadisticas(pacientes);
        mostrarClasificacionesIMC(pacientes);
    }

    /**
     * Muestra todos los pacientes generados.
     *
     * @param pacientes lista de pacientes a mostrar
     */
    private static void mostrarPacientes(Pacientes pacientes) {
        System.out.println("===== LISTADO DE PACIENTES =====");
        System.out.println(pacientes);
    }

    /**
     * Muestra estadísticas generales: edades mínima y máxima, y conteo por sexo.
     *
     * @param pacientes lista de pacientes
     */
    private static void mostrarEstadisticas(Pacientes pacientes) {
        int[] edades = pacientes.menorMayor();
        int[] sexos = pacientes.pacientesPorSexo();

        System.out.println("\n===== ESTADÍSTICAS GENERALES =====");
        System.out.println("Edad mínima: " + edades[0]);
        System.out.println("Edad máxima: " + edades[1]);
        System.out.println("Cantidad de pacientes masculinos: " + sexos[0]);
        System.out.println("Cantidad de pacientes femeninos: " + sexos[1]);
    }

    /**
     * Muestra la clasificación del IMC de cada paciente.
     *
     * @param pacientes lista de pacientes
     */
    private static void mostrarClasificacionesIMC(Pacientes pacientes) {
        System.out.println("\n===== CLASIFICACIÓN IMC DE PACIENTES =====");
        for (Object obj : pacientes) {
            Paciente paciente = (Paciente) obj;
            IMC imc = paciente.getIMC();
            System.out.println("Paciente ID " + paciente.getId() + " - IMC: " + paciente.calcularIMC() + " - " + imc);
        }
    }
}

