package tech.romashov.core;

/**
 * Интерфейс для получения некоторого значения.
 *
 * @author Vladimir Popov &lt;v.popov@crystals.ru&gt;
 */
public interface ThrowableGetter<T> {
    T get() throws Throwable;
}
