package com.BYjosep.Tema9.Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Cola<T> implements ICola<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private final static float GROW_FACTOR = 2f;
    private List<T> data;


    public Cola() {
        this(DEFAULT_CAPACITY);
    }

    public Cola(int capacity) {
        data = new ArrayList<>(capacity);

    }

    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T value) {
        data.add(value);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T valor = peek();
        data.removeFirst();

        return valor;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return data.getFirst();
    }


    public void clear() {
        for (int i = 0; i < size(); i++) {
            data.set(i, null);
        }
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return data.getLast();
    }

    public int search(T element) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < size(); i++) {
            if (element == null) {
                if (data.get(i) == null) {
                    return i + 1;
                }
            } else if (element.equals(data.get(i))) {
                return i + 1;
            }
        }
        return -1;
    }

    public void reverse() {
        if (isEmpty() || size() == 1) {
            return;
        }
        data = data.reversed();
    }

    /*
    public void reverse2() {
        if (isEmpty() || size() == 1) {
            return;
        }
        Object[] aux = new Object[size()];
        int originalSize = size();

        for (int i = 0; i < originalSize; i++) {
            aux[i] = remove();
        }
        for (int i = originalSize - 1; i >= 0; i--) {
            add((T)aux[i]);
        }
    }

     */

    public void reverse3() {
        if (isEmpty() || size() == 1) {
            return;
        }

        T first = remove();
        if (!isEmpty()) {
            reverse3();
        }
        add(first);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cola<?> cola = (Cola<?>) o;
        if (size() != cola.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (data.get(i) == null) {
                if (cola.data.get(i) != null) {
                    return false;
                }
            } else if (!data.get(i).equals(cola.data.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size(); i++) {
            result = 31 * result + (data.get(i) == null ? 0 : data.get(i).hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola[\n");
        for (int i = 0; i < size(); i++) {
            sb.append(data.get(i));
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.replace(sb.length() - 2, sb.length(), "\n]");

        return sb.toString();
    }
}