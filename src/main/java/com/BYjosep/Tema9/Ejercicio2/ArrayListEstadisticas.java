package com.BYjosep.Tema9.Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListEstadisticas implements iEstadisticas{
    private List<Double> lista;

    public ArrayListEstadisticas() {
        this.lista = new ArrayList<>();
    }

    public void add (double valor){
        lista.add(valor);
    }



    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (double valor : lista) {
            if (valor < min) {
                min = valor;
            }
        }

        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for (double valor : lista) {
            if (valor > max) {
                max = valor;
            }
        }

        return max;
    }

    @Override
    public double sumatorio() {
        double sum = 0;
        for (double valor : lista) {
            sum += valor;
        }
        return sum;
    }

    @Override
    public double media() {
        double suma = sumatorio();
        return suma / lista.size();
    }

    @Override
    public double moda() {
        Set<Double> set = new TreeSet<>();
        set.addAll(this.lista);

        return 0;
    }
}
