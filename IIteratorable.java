// package me.tool.stream;

import java.util.Iterator;

public interface IIteratorable<E> {
    Iterator<E> getIterator(Iterator<E> sourceIterator);
}
