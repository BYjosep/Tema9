package com.BYjosep.Tema9.lib.generics;

import java.util.Arrays;
import java.util.Objects;

public class Cola<T> {

    private static final String ERROR = null;
    private final static int DEFAULT_CAPACITY = 10;
    private final static float GROW_FACTOR = 2f;
    private T[] data;
    private int size;

    public Cola() {
        this(DEFAULT_CAPACITY);
    }

    public Cola(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        data = temp;
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cola<T> cola = (Cola<T>) o;
        return size == cola.size && Objects.deepEquals(data, cola.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(data), size);
    }

    public T peek() {
        if (isEmpty()) return null; // Si la cola está vacía, retorna null.
        return data[0]; // Devuelve el primer elemento de la cola.
    }

    private T get(int index) {
        if (index >= size || index < 0)
            return null;
        return data[index];
    }

    public boolean add(T value) {
        if (isFull()) {
            expand();
        }
        data[size++] = value;
        return true;
    }

    private boolean add(int index, T value) {
        if (index > size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }

    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public T remove() {
        if (isEmpty()) return null; // Si la cola está vacía, retorna null.
        T value = data[0]; // Guarda el primer elemento.
        moveToLeft(0); // Desplaza los elementos a la izquierda.
        return value; // Retorna el primer elemento.
    }

    private T remove(int index) {
        if (index >= size || index < 0)
            return null;
        T value = data[index];
        moveToLeft(index);
        return value;
    }

    private void expand() {
        T[] copy = (T[]) new Object[Math.round(data.length * GROW_FACTOR)];
        System.arraycopy(data, 0, copy, 0, size);
        data = copy;
    }

    public int size() {
        return size;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        if (size == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        data = (T[]) new Object[data.length];
        size = 0;
    }

    public Cola<T> clone() {
        Cola<T> newCola = new Cola<>(this.size()); // Crea una nueva cola con la misma capacidad.
        System.arraycopy(this.data, 0, newCola.data, 0, this.size()); // Copia los elementos.
        newCola.size = this.size; // Copia el tamaño.
        return newCola; // Retorna la nueva cola.
    }

    public T peekLast() {
        if (isEmpty()) return null; // Si la cola está vacía, retorna null.
        return data[size - 1]; // Devuelve el último elemento.
    }

    public String peekLastToStr() {
        if (isEmpty()) return null; // Si la cola está vacía, retorna null.
        return data[size - 1].toString(); // Devuelve el último elemento como String.
    }

    public int search(T value) {
        if (isEmpty()) return -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) return i;
        }
        return -1;
    }

    public T[] reverse() {
        T[] aux = (T[]) new Object[size];
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            aux[j] = data[i];
            j++;
        }
        return aux;
    }
}