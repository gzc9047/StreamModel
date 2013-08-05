// package me.tool.stream;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Filter<ReturnType> implements IIteratorable<ReturnType> {
    private static final String HANDLE_METHOD_NAME = "handle";
    private Method handler;
    public Filter() {
        for (final Method m : this.getClass().getDeclaredMethods()) {
            if (m.getName().equals(HANDLE_METHOD_NAME)) {
                handler = m;
                break;
            }
        }
        if (handler == null) {
            throw new RuntimeException("no handler with method name: " + HANDLE_METHOD_NAME);
        }
        handler.setAccessible(true);
    }

    public Boolean filte(final Object o) throws Exception {
        return (Boolean)(handler.invoke(this, o));
    }

    private static class FilterIterator<E> implements Iterator<E> {
        private final Filter<E> filter;
        private final Iterator<E> sourceIterator;
        private E next;
        FilterIterator(final Filter<E> filter, final Iterator<E> sourceIterator) {
            this.filter = filter;
            this.sourceIterator = sourceIterator;
        }

        public boolean hasNext() {
            while (sourceIterator.hasNext()) {
                E e = sourceIterator.next();
                try {
                    if (filter.filte(e).booleanValue()) {
                        next = e;
                        return true;
                    }
                } catch (Exception _) {
                    return false;
                }
            }
            return false;
        }

        public E next() throws NoSuchElementException {
            return next;
        }

        public void remove() {
            throw new RuntimeException("not implemented.");
        }
    }

    public Iterator<ReturnType> getIterator(Iterator<ReturnType> sourceIterator) {
        return new FilterIterator<ReturnType>(this, sourceIterator);
    }
}
