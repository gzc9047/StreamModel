// package me.tool.stream;

import java.lang.reflect.Method;

public interface IFilter<E> {
    Boolean filte(final E o) throws Exception;
}
