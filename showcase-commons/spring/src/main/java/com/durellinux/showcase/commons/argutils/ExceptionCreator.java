package com.durellinux.showcase.commons.argutils;

public interface ExceptionCreator<E extends Exception> {
    E create();
}
