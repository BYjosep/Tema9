package com.BYjosep.Tema9.Ejercicio11;

import java.util.*;

public class CentroEducativo {

    private final Collection<Alumno> alumnos;
    private final Map<Grupo, Set<Alumno>> alumnosPorGrupo;
    private final Map<Profesor, Set<Alumno>> alumnosPorProfesor;
    private final Collection<Grupo> grupos;
    private final Collection<Asignatura> asignaturas;
    private final Collection<Profesor> profesores;
    private final Collection<Aula> aulas;

    public CentroEducativo() {
        this.alumnos = new HashSet<>();
        this.alumnosPorGrupo = new HashMap<>();
        this.alumnosPorProfesor = new HashMap<>();
        this.grupos = new HashSet<>();
        this.asignaturas = new HashSet<>();
        this.profesores = new HashSet<>();
        this.aulas = new HashSet<>();
    }

    /**
     * Da de alta un nuevo alumno en el sistema.
     * @param alumno El alumno a registrar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaAlumno(Alumno alumno) {
        return alumnos.add(alumno);
    }

    /**
     * Da de alta un nuevo grupo en el sistema.
     * @param grupo El grupo a registrar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaGrupo(Grupo grupo) {
        return grupos.add(grupo);
    }

    /**
     * Da de alta una nueva asignatura en el sistema.
     * @param asignatura La asignatura a registrar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaAsignatura(Asignatura asignatura) {
        return asignaturas.add(asignatura);
    }

    /**
     * Da de alta un nuevo profesor en el sistema.
     * @param profesor El profesor a registrar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaProfesor(Profesor profesor) {
        return profesores.add(profesor);
    }

    /**
     * Da de alta un nuevo aula en el sistema.
     * @param aula El aula a registrar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaAula(Aula aula) {
        return aulas.add(aula);
    }

    public Collection<Alumno> obtenerAlumnos() {
        return new HashSet<>(alumnos);
    }

    public Collection<Grupo> obtenerGrupos() {
        return new HashSet<>(grupos);
    }

    public Collection<Asignatura> obtenerAsignaturas() {
        if (asignaturas.isEmpty()) {
            throw new IllegalStateException("No se han encontrado asignaturas");
        }
        return new HashSet<>(asignaturas);
    }

    public Collection<Profesor> obtenerProfesores() {
        if (profesores.isEmpty()) {
            throw new IllegalStateException("No se han encontrado profesores");
        }
        return new HashSet<>(profesores);
    }


    public Collection<Aula> obtenerAulas() {
        if (aulas.isEmpty()) {
            throw new IllegalStateException("No se han encontrado aula");
        }
        return new HashSet<>(aulas);
    }

    public Collection<Alumno> obtenerAlumnosPorGrupo(Grupo grupo) {
        return alumnosPorGrupo.getOrDefault(grupo, Collections.emptySet());
    }

    public Collection<Alumno> obtenerAlumnosPorProfesor(Profesor profesor) {
        return alumnosPorProfesor.getOrDefault(profesor, Collections.emptySet());
    }

    /**
     * Asigna una asignatura a un alumno y actualiza el registro del profesor correspondiente.
     * @param alumno El alumno al que se le asignará la asignatura.
     * @param asignatura La asignatura a asignar.
     * @return true si se asignó correctamente, false si el alumno no existe o ya tenía la asignatura.
     */
    public boolean asignarAsignaturaAAlumno(Alumno alumno, Asignatura asignatura) {
        if (!alumnos.contains(alumno)) return false;
        boolean agregado = alumno.getAsignaturas().add(asignatura);
        if (agregado) {
            alumnosPorProfesor.computeIfAbsent(asignatura.getProfesor(), p -> new HashSet<>()).add(alumno);
        }
        return agregado;
    }

    /**
     * Asocia un alumno a un grupo dentro del sistema.
     * @param alumno El alumno a asignar.
     * @param grupo El grupo al que se asignará.
     * @return true si se asignó correctamente, false si el alumno o grupo no están registrados.
     */
    public boolean asignarGrupoAAlumno(Alumno alumno, Grupo grupo) {
        if (!alumnos.contains(alumno)||!grupos.contains(grupo) ) return false;


        alumnosPorGrupo.computeIfAbsent(grupo, g -> new HashSet<>()).add(alumno);
        return true;
    }

    /**
     * Devuelve una representación en texto de todos los alumnos asignados a un profesor.
     * @param profesor El profesor a consultar.
     * @return Cadena formateada con los alumnos asociados.
     * @throws NoSuchElementException si el profesor no tiene alumnos asociados.
     */
    public String mostrarAlumnosPorProfesor(Profesor profesor) throws NoSuchElementException {
        StringBuilder sb = new StringBuilder();
        sb.append("Profesor: ").append(profesor).append("[\nAlumnos: ");

        Set<Alumno> alumnosSet = alumnosPorProfesor.get(profesor);
        if (alumnosSet != null && !alumnosSet.isEmpty()) {
            // Convertir a lista sin stream
            List<Alumno> alumnos = new ArrayList<>(alumnosSet);
            for (Alumno alumno : alumnos) {
                sb.append("(").append(alumno.getNombre()).append(") ");
            }
        } else {
            throw new NoSuchElementException("¿Dónde vas? ¡No existe ningún alumno!");
        }

        sb.append("\n}\n");
        return sb.toString();
    }


    /**
     * Devuelve una representación en texto de todos los alumnos asignados a un grupo.
     * @param grupo El grupo a consultar.
     * @return Cadena formateada con los alumnos asociados.
     * @throws NoSuchElementException si el grupo no tiene alumnos asociados.
     */
    public String mostrarAlumnosPorGrupo(Grupo grupo) throws NoSuchElementException{
        StringBuilder sb = new StringBuilder();
        sb.append("Grupo: ").append(grupo).append("[\nAlumnos: ");
        Set<Alumno> alumnos = alumnosPorGrupo.get(grupo);
        if (alumnos != null && !alumnos.isEmpty()) {
            for (Alumno alumno : alumnos) {
                sb.append("(").append(alumno.getNombre()).append(") ");
            }
        } else {
            throw new NoSuchElementException("¿Dónde vas? ¡No existe ningún alumno!");
        }
        sb.append("\n}\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "alumnos=" + alumnos +
                ", grupos=" + grupos +
                ", asignaturas=" + asignaturas +
                ", profesores=" + profesores +
                ", aulas=" + aulas +
                '}';
    }
}