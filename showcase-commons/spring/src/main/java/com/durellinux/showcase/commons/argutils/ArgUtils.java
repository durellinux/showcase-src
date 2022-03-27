package com.durellinux.showcase.commons.argutils;

public class ArgUtils {
    private ArgUtils() { }

    public static void assertNotNull(Object value) {
        assertNotNull(value, "Value can't be null");
    }

    public static void assertNotNull(Object value, final String message) {
        assertNotNull(value, () -> new IllegalArgumentException(message));
    }

    public static <E extends Exception> void assertNotNull(Object value, ExceptionCreator<E> e) throws E  {
        if (value == null) {
            throw e.create();
        }
    }
}
