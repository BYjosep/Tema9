package com.BYjosep.Tema9.Ejercicio11;

import com.BYjosep.Tema9.lib.Int.LibInInts;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CentroEducativo centro = new CentroEducativo();


    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            int opcion = LibInInts.ingresarUnNumero("""
                    MENÚ CENTRO EDUCATIVO
                    ------------------------
                    1. Alta alumno
                    2. Alta profesor
                    3. Alta asignatura
                    4. Alta grupo
                    5. Alta aula
                    6. Asignar asignatura a alumno
                    7. Asignar grupo a alumno
                    8. Mostrar alumnos por profesor
                    9. Mostrar alumnos por grupo
                    0. Salir
                    Selecciona una opción:
                    """, 0, 9, "Opción fuera de rango");

            switch (opcion) {
                case 1 -> altaAlumno();
                case 2 -> altaProfesor();
                case 3 -> altaAsignatura();
                case 4 -> altaGrupo();
                case 5 -> altaAula();
                case 6 -> asignarAsignatura();
                case 7 -> asignarGrupo();
                case 8 -> mostrarAlumnosPorProfesor();
                case 9 -> mostrarAlumnosPorGrupo();
                case 0 -> salir = true;
            }
        }
    }

    /**
     * Da de alta un nuevo alumno solicitando nombre y grupo.
     */
    private static void altaAlumno() {
        System.out.print("Nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del grupo: ");
        int idGrupo = Integer.parseInt(scanner.nextLine());
        Grupo grupo = centro.obtenerGrupos().stream().filter(g -> g.getId() == idGrupo).findFirst().orElse(null);
        if (grupo == null) {
            System.out.println("Grupo no encontrado.");
            return;
        }
        Alumno alumno = new Alumno(nombre, grupo);
        centro.altaAlumno(alumno);
        centro.asignarGrupoAAlumno(alumno, grupo);
        System.out.println("Alumno registrado y asignado al grupo.");
    }

    /**
     * Da de alta un nuevo profesor solicitando DNI, nombre y sueldo.
     */
    private static void altaProfesor() {
        System.out.print("DNI del profesor: ");
        String dni = scanner.nextLine();
        System.out.print("Nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = Double.parseDouble(scanner.nextLine());
        Profesor profesor = new Profesor(dni, nombre, sueldo);
        centro.altaProfesor(profesor);
        System.out.println("Profesor registrado.");
    }

    /**
     * Da de alta una nueva asignatura solicitando el nombre y el DNI del profesor.
     */
    private static void altaAsignatura() {
        System.out.print("Nombre de la asignatura: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI del profesor: ");
        String dni = scanner.nextLine();
        Profesor profesor = centro.obtenerProfesores().stream().filter(p -> p.getDni().equals(dni)).findFirst().orElse(null);
        if (profesor == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }
        Asignatura asignatura = new Asignatura(nombre, profesor);
        centro.altaAsignatura(asignatura);
        System.out.println("Asignatura registrada.");
    }

    /**
     * Da de alta un nuevo grupo solicitando nombre y aula existente.
     */
    private static void altaGrupo() {
        System.out.print("Nombre del grupo: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del aula: ");
        int idAula = Integer.parseInt(scanner.nextLine());
        Aula aula = centro.obtenerAulas().stream().filter(a -> a.getId() == idAula).findFirst().orElse(null);
        if (aula == null) {
            System.out.println("Aula no encontrada.");
            return;
        }
        Grupo grupo = new Grupo(nombre, aula);
        centro.altaGrupo(grupo);
        System.out.println("Grupo registrado.");
    }

    /**
     * Da de alta un nuevo aula solicitando sus metros cuadrados.
     */
    private static void altaAula() {
        System.out.print("Metros cuadrados del aula: ");
        double m2 = Double.parseDouble(scanner.nextLine());
        Aula aula = new Aula(m2);
        centro.altaAula(aula);
        System.out.println("Aula registrada.");
    }

    /**
     * Asigna una asignatura existente a un alumno registrado.
     */
    private static void asignarAsignatura() {
        System.out.print("ID del alumno: ");
        int idAlumno = Integer.parseInt(scanner.nextLine());
        Alumno alumno = centro.obtenerAlumnos().stream().filter(a -> a.getId() == idAlumno).findFirst().orElse(null);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }
        System.out.print("ID de la asignatura: ");
        int idAsig = Integer.parseInt(scanner.nextLine());
        Asignatura asignatura = centro.obtenerAsignaturas().stream().filter(a -> a.getId() == idAsig).findFirst().orElse(null);
        if (asignatura == null) {
            System.out.println("Asignatura no encontrada.");
            return;
        }
        centro.asignarAsignaturaAAlumno(alumno, asignatura);
        System.out.println("Asignatura asignada al alumno.");
    }

    /**
     * Asigna un grupo existente a un alumno registrado.
     */
    private static void asignarGrupo() {
        System.out.print("ID del alumno: ");
        int idAlumno = Integer.parseInt(scanner.nextLine());
        Alumno alumno = centro.obtenerAlumnos().stream().filter(a -> a.getId() == idAlumno).findFirst().orElse(null);
        System.out.print("ID del grupo: ");
        int idGrupo = Integer.parseInt(scanner.nextLine());
        Grupo grupo = centro.obtenerGrupos().stream().filter(g -> g.getId() == idGrupo).findFirst().orElse(null);
        if (alumno == null || grupo == null) {
            System.out.println("Alumno o grupo no encontrado.");
            return;
        }
        centro.asignarGrupoAAlumno(alumno, grupo);
        System.out.println("Grupo asignado al alumno.");
    }

    /**
     * Muestra los alumnos asignados a un profesor según su DNI.
     */
    private static void mostrarAlumnosPorProfesor() {
        Profesor profesor= new Profesor(null,null,0);
        if (profesor != null) {

        } else {
            throw new NoSuchElementException("Profesor no encontrado.");
        }
    }

    /**
     * Muestra los alumnos asignados a un grupo según su ID.
     */
    private static void mostrarAlumnosPorGrupo() {

        Grupo grupo = new Grupo(null,null);
        if (grupo != null) {

        } else {
            throw new NoSuchElementException("Grupo no encontrado.");
        }
    }
}