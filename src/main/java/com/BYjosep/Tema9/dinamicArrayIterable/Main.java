package com.BYjosep.Tema9.dinamicArrayIterable;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> datos = new DynamicArray<>(100);
        for (int i = 0; i < 50; i++) {
            datos.add(i);
        }

        for(int num : datos) {
            System.out.println(num);
        }

    }
}
