package com.BYjosep.Tema9.lib.generics;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> {

    private final static int DEFAULT_CAPACITY = 10;
    private final static float GROW_FACTOR = 2f;
    private T[] data;
    private int size;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray<?> that = (DynamicArray<?>) o;
        if (size != that.size) return false;

        for (int i = 0; i < size; i++) {
            if (!Objects.deepEquals(data[i], that.data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        for (int i = 0; i < size; i++) {
            result = 31 * result + Objects.hashCode(data[i]);
        }
        return result;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        return data[index];
    }

    public boolean add(T value) {
        if (isFull())
            expand();
        data[size++] = value;
        return true;
    }

    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }

    public boolean add(int index, T value) {
        if (index > size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        T value = data[index];
        moveToLeft(index);
        return value;
    }

    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], value)) {
                moveToLeft(i);
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, T value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    private void expand() {
        int newCapacity = Math.max(DEFAULT_CAPACITY, Math.round(data.length * GROW_FACTOR));
        T[] copy = (T[]) new Object[newCapacity];
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
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public T[] clone() {
        return Arrays.copyOf(data, size);
    }

    public void copyTo(T[] destination) {
        if (destination.length < size) {
            throw new IllegalArgumentException("Array destino demasiado pequeño");
        }
        System.arraycopy(data, 0, destination, 0, size);
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], value)) return i;
        }
        return -1;
    }

    public void trimToSize() {
        data = Arrays.copyOf(data, size);
    }

    public boolean swap(int index1, int index2) {
        if (index1 >= size || index2 >= size || index1 < 0 || index2 < 0)
            return false;
        T aux = data[index1];
        data[index1] = data[index2];
        data[index2] = aux;
        return true;
    }
}