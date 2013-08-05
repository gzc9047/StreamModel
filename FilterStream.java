// package me.tool.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterStream<E> extends AbstractStream<E> {
    private final Filter<E> filter;
    private final Iterator<E> sourceIterator;

    // TODO(guzuchao): more check of parameter type.
    public FilterStream(final E[] source, final Filter<E> filter) {
        this(Arrays.<E>asList(source), filter);
    }

    public FilterStream(final Collection<E> source, final Filter<E> filter) {
        this.sourceIterator = source.iterator();
        this.filter = filter;
    }

    public Iterator<E> iterator() {
        return filter.getIterator(sourceIterator);
    }
}
