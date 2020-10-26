package tech.romashov.core.assertions;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public class AssertWithTimeout {
    public static <T> T assertThat(ThrowableGetter<T> getter, Matcher<? super T> matcher, long timeout) throws Throwable {
        return assertThat("", getter, matcher, timeout);
    }

    public static <T> T assertThat(ThrowableGetter<T> getter, Matcher<? super T> matcher, long timeout, long delay) throws Throwable {
        return assertThat("", getter, matcher, timeout, delay);
    }

    public static <T> T assertThat(String reason, ThrowableGetter<T> getter, Matcher<? super T> matcher, long timeout) throws Throwable {
        return assertThat(reason, getter, matcher, timeout, 100);
    }

    /**
     * Утверждает, что выражение, возвращенное {@code getter}-ом, максимум  за время {@code timeout}, будет соответствовать {@code matcher}-у.
     *
     * @param reason  комментарий на случай провала утверждения.
     * @param getter  инструмент для получения текущего значения проверяемой величины.
     * @param matcher описание требования к проверяемой величине.
     * @param timeout максимальное время ожидания "ожидаемого" значения в миллисекундах.
     * @param delay   период перезапроса значения проверяемой величины в миллисекундах.
     * @param <T>     тип проверяемого значения.
     * @throws Throwable
     */
    public static <T> T assertThat(String reason, ThrowableGetter<T> getter, Matcher<? super T> matcher, long timeout, long delay) throws Throwable {
        T actual = waitAndGetActualValue(getter, matcher, timeout, delay);
        if (!matcher.matches(actual)) {
            Description description = new StringDescription();
            description.appendText(reason)
                    .appendText("\nExpected: ")
                    .appendDescriptionOf(matcher)
                    .appendText("\n but: ");
            matcher.describeMismatch(actual, description);
            throw new AssertionError(description.toString());
        }
        return actual;
    }

    private static <T> T waitAndGetActualValue(ThrowableGetter<T> getter, Matcher<? super T> matcher, long timeout, long delay) throws Throwable {
        long begin = System.currentTimeMillis();
        T value = getter.get();
        while (System.currentTimeMillis() - begin < timeout && !matcher.matches(value)) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = getter.get();
        }
        return value;
    }

    @Override
    @Deprecated
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
