package com.BYjosep.Tema9.Ejercicio3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Pila<T> implements IPila<T> {
    private static final int INITIAL_SIZE = 10;
    private static final float GROW_FACTOR = 2f;
    private List<T> data;

    public Pila() {
        this(INITIAL_SIZE);
    }

    public Pila(int capacity) {
        data = new ArrayList<>(capacity);
    }

    @Override
    public T push(T e) {
        data.add(e);
        return e;
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T e = data.remove(data.size() - 1);
        return e;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(size()-1);

    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            data = null;
        }

    }



    public T peek(int n) {
        if (n <= 0 || n > size() || isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (T)data.get(size()-n);
    }

    public void peekElements(int n) {
        if (n <= 0 || isEmpty()) {
            return;
        }
        if (n > size()) {
            n = size();
        }
        System.out.print("Elementos superiores: ");
        for (int i = 0; i < n; i++) {
            System.out.print(data.get(size() - 1 - i) + " ");
        }
        System.out.println();
    }

    public int search(T element) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = size() - 1; i >= 0; i--) {
            if (element == null) {
                if (data.get(i)== null) {
                    return size() - i;
                }
            } else if (element.equals(data.get(i))) {
                return size() - i;
            }
        }
        return -1;
    }

    public void reverse() {
        if (isEmpty() || size() == 1) {
            return;
        }
        ArrayList<T> temp = new ArrayList<>(size());
        temp.addAll(data.reversed());
    }
/*
    public void reverse2() {
        if (isEmpty() || size == 1) {
            return;
        }
        Object[] aux = new Object[size];
        int originalSize = size;
        for (int i = 0; i < originalSize; i++) {
            aux[i] = pop();
        }
        for (int i = 0; i < originalSize; i++) {
            push((T)aux[i]);
        }
    }

 */


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pila<?> other = (Pila<?>) obj;
        if (size() != other.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (data.get(i) == null) {
                if (other.data.get(i) != null) {
                    return false;
                }
            } else if (!data.get(i).equals(other.data.get(i))) {
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
        StringBuilder sb = new StringBuilder("Pila[ ").append("\n");
        for (int i = 0; i < size(); i++) {
            sb.append(data.get(i)).append(", ");
        }
        sb.replace(sb.length()-2, sb.length(),"").append("\n").append("]");
        return sb.toString();
    }
}