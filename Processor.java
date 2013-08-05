// package me.tool.stream;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Processor<ReturnType> implements IIteratorable<ReturnType> {
    private static final String HANDLE_METHOD_NAME = "handle";
    private Method handler;
    public Processor() {
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

    public ReturnType process(final Object o) throws Exception {
        return (ReturnType)(handler.invoke(this, o));
    }

    private static class StreamIterator<E> implements Iterator<E> {
        private final Processor<E> processor;
        private final Iterator sourceIterator;
        StreamIterator(final Processor<E> processor, final Iterator sourceIterator) {
            this.processor = processor;
            this.sourceIterator = sourceIterator;
        }

        public boolean hasNext() {
            return sourceIterator.hasNext();
        }

        public E next() throws NoSuchElementException {
            try {
                return processor.process(this.sourceIterator.next());
            } catch (Exception e) {
                throw new NoSuchElementException(e.getStackTrace().toString());
            }
        }

        public void remove() {
            throw new RuntimeException("not implemented.");
        }
    }

    public Iterator<ReturnType> getIterator(Iterator<ReturnType> sourceIterator) {
        return new StreamIterator<ReturnType>(this, sourceIterator);
    }
}
