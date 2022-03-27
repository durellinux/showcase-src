package com.durellinux.showcase.commons.rest;

public class SearchFilter {
    private String key;
    private FilterOperation operation;
    private Object value;

    public SearchFilter() {
    }

    public SearchFilter(String key, FilterOperation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public FilterOperation getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }
}
