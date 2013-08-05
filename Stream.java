// package me.tool.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stream<E> extends AbstractStream<E> {
    private final Processor<E> processor;
    private final Iterator sourceIterator;

    // TODO(guzuchao): more check of parameter type.
    public Stream(final Object[] source, final Processor<E> processor) {
        this(Arrays.asList(source), processor);
    }

    public Stream(final Collection source, final Processor<E> processor) {
        this.sourceIterator = source.iterator();
        this.processor = processor;
    }

    public Iterator<E> iterator() {
        return processor.getIterator(sourceIterator);
    }
}
