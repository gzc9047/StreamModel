// package me.tool.stream;

import java.util.Collection;
import java.util.Iterator;

/**
 * just mark the method not implement, except iterator().
 */
public abstract class AbstractStream<E> implements Collection<E> {
    // need subclass implement.
    // Iterator<E> iterator();

    public boolean add(E e) {
        throw new RuntimeException("not implemented.");
    }
    public boolean addAll(Collection<? extends E> c) {
        throw new RuntimeException("not implemented.");
    }
    public void clear() {
        throw new RuntimeException("not implemented.");
    }
    public boolean contains(Object o) {
        throw new RuntimeException("not implemented.");
    }
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("not implemented.");
    }
    public boolean equals(Object o) {
        throw new RuntimeException("not implemented.");
    }
    public int hashCode() {
        throw new RuntimeException("not implemented.");
    }
    public boolean isEmpty() {
        throw new RuntimeException("not implemented.");
    }
    public boolean remove(Object o) {
        throw new RuntimeException("not implemented.");
    }
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("not implemented.");
    }
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("not implemented.");
    }
    public int size() {
        throw new RuntimeException("not implemented.");
    }
    public Object[] toArray() {
        throw new RuntimeException("not implemented.");
    }
    public <T> T[] toArray(T[] a) {
        throw new RuntimeException("not implemented.");
    }
}
