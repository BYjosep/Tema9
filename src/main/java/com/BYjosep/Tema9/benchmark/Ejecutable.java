package com.germangascon.ejemplosclase.tema09.benchmark;

import java.util.Random;

/**
 * Task
 * License: 🅮 Public Domain
 * Created on: 2025-04-09
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.0.1
 * @since 0.0.1
 **/
public interface Ejecutable {
    void start(int size, int times, int seekValue, Random random);
    String getDescription();
}
