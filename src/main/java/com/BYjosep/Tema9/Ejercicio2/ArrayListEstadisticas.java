package com.BYjosep.Tema9.Ejercicio2;

import java.util.*;

public class ArrayListEstadisticas implements iEstadisticas {
    private final List<Double> lista;

    public ArrayListEstadisticas() {
        this(1);
    }

    public ArrayListEstadisticas(int initialCapacity) {
        this.lista = new ArrayList<>(initialCapacity);
    }

    public void add(double valor) {
        try {
            lista.add(valor);
        } catch (Exception e) {
            System.out.println("Fatal error");
        }
    }


    public int size() {
        return lista.size();
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
        int maximo = Integer.MIN_VALUE;
        double valor = 0;
        Map<Double, Integer> map = new HashMap<>(lista.size());
        for (Double aDouble : lista) {
            if (map.containsKey(aDouble)) {
                map.put(aDouble, map.get(aDouble) + 1);
            } else {
                map.put(aDouble, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maximo) {
                maximo = entry.getValue();
                valor = entry.getKey();
            }
        }

        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListEstadisticas that = (ArrayListEstadisticas) o;
        return Objects.equals(lista, that.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lista);
    }

    @Override
    public String toString() {
        return "ArrayListEstadisticas{" +
                "lista=" + lista +
                '}';
    }
}
