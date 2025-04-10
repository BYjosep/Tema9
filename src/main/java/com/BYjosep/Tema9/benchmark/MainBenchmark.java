package com.germangascon.ejemplosclase.tema09.benchmark;

/**
 * MainBenchmark
 * License: 🅮 Public Domain
 * Created on: 2025-04-10
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.0.1
 * @since 0.0.1
 **/
public class MainBenchmark {
    public static void main(String[] args) {
        Ejecutable array = new ArrayTask();
        Ejecutable arrayList = new ArrayListTask();
        Benchmark benchmark = new Benchmark(1_000_000, 10, 10);
        benchmark.addEjecutable(array);
        benchmark.addEjecutable(arrayList);
        benchmark.iniciar();
        System.out.println(benchmark);
    }
}
