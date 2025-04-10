package com.germangascon.ejemplosclase.tema09.benchmark;

import java.util.*;

/**
 * Benchmark
 * License: 🅮 Public Domain
 * Created on: 2025-04-09
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.0.1
 * @since 0.0.1
 **/
public class Benchmark {
    private static final int NANOS_TO_SECOND = 1_000_000_000;
    private final int repeticiones;
    private final int size;
    private final int times;
    private final List<Ejecutable> tareas;
    private final Map<Integer, List<Double>> stats;


    public Benchmark(int size, int times, int repeticiones) {
        this.size = size;
        this.times = times;
        this.repeticiones = repeticiones;
        this.stats = new HashMap<>();
        this.tareas = new ArrayList<>();
    }

    public void addEjecutable(Ejecutable ejecutable) {
        tareas.add(ejecutable);
    }

    public void iniciar() {
        long inicio, fin;
        Random random = new Random();
        int seekNumber = random.nextInt();
        for (int i = 0; i < tareas.size(); i++) {
            random.setSeed(1234);
            Ejecutable ejecutable = tareas.get(i);
            List<Double> ejecuciones = new ArrayList<>();
            for (int j = 0; j < repeticiones; j++) {
                inicio = System.nanoTime();
                ejecutable.start(size, times, seekNumber, random);
                fin = System.nanoTime();
                ejecuciones.add((double) (fin - inicio) / NANOS_TO_SECOND);
            }
            stats.put(i, ejecuciones);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Double>> entry : stats.entrySet()) {
            int indice = entry.getKey();
            double suma = 0;
            List<Double> ejecuciones = entry.getValue();
            Ejecutable ejecutable = tareas.get(indice);
            sb.append(ejecutable.getDescription()).append(":\n");
            for (Double tiempo: ejecuciones) {
                suma += tiempo;
                sb.append(String.format("%4s", " ")).append(tiempo).append(" seconds").append("\n");
            }
            sb.append(String.format("Media: %.4f\n", suma / ejecuciones.size()));
        }
        return sb.toString();
    }
}
