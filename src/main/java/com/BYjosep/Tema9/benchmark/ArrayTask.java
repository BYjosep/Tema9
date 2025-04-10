package com.germangascon.ejemplosclase.tema09.benchmark;

import java.util.Random;

/**
 * ArrayVsArrayList
 * License: 🅮 Public Domain
 * Created on: 2025-04-10
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.0.1
 * @since 0.0.1
 **/
public class ArrayTask implements Ejecutable {
    @Override
    public void start(int size, int times, int seekValue, Random random) {
        // random.setSeed(System.nanoTime());
        int[] datos = new int[size];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < datos.length; j++) {
                datos[j] = random.nextInt();
            }
        }

        for (int i = 0; i < times; i++) {
            for (int dato : datos) {
                if (dato == seekValue) {
                    return;
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Array";
    }
}
