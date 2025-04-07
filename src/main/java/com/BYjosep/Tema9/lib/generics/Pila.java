package com.BYjosep.Tema9.lib.generics;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Pila<T> {

    private static final int INITIAL_SIZE = 10;
    private static final float GROW_FACTOR = 2f;
    private T[] data;
    private int size;

    public Pila() {
        this(INITIAL_SIZE);
    }

    @SuppressWarnings("unchecked")
    public Pila(int size) {
        data = (T[]) new Object[size];
        this.size = 0;
    }

    public void push(T elemento) {
        if (isFull())
            expand();
        data[size++] = elemento;
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        int newCapacity = Math.max(INITIAL_SIZE, Math.round(data.length * GROW_FACTOR));
        T[] aux = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, aux, 0, size);
        data = aux;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T e = data[--size];
        data[size] = null; // Ayuda al recolector de basura
        return e;
    }

    public T top() {
        if (isEmpty())
            throw new EmptyStackException();
        return data[size - 1];
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] clone() {
        return Arrays.copyOf(data, size);
    }

    public void copyTo(T[] destination) {
        if (destination.length < size)
            throw new IllegalArgumentException("Array destino demasiado pequeño");
        System.arraycopy(data, 0, destination, 0, size);
    }

    public String peekToStr(int index) {
        if (index <= 0 || isEmpty()) return "[]";

        int elementsToShow = Math.min(index, size);
        StringBuilder sb = new StringBuilder();
        sb.append("Últimos ").append(elementsToShow).append(" elementos: [ ");
        for (int i = size - 1; i >= size - elementsToShow; i--) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void peek(int index) {
        System.out.println(peekToStr(index));
    }

    @SuppressWarnings("unchecked")
    public T[] reverse() {
        if (isEmpty() || size == 1) {
            return data;
        }
        T[] aux = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            aux[i] = data[size - i - 1];
        }
        return aux;
    }
    public int search(T element) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(data[i], element)) {
                return size - i; // Distancia desde la cima
            }
        }
        return -1; // Elemento no encontrado
    }
}