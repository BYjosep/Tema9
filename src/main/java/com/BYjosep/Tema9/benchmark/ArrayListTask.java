package com.germangascon.ejemplosclase.tema09.benchmark;

import java.util.ArrayList;
import java.util.List;
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
public class ArrayListTask implements Ejecutable {
    @Override
    public void start(int size, int times, int seekValue, Random random) {
        List<Integer>  datos = new ArrayList<>(size);
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < size; j++) {
                datos.add(random.nextInt());
            }
            datos.clear();
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
        return "ArrayList";
    }
}
