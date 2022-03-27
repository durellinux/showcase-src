package com.durellinux.showcase.commons.rest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaginatedResponse<T> {
    private final int currentPage;
    private final int totalPages;
    private final int pageSize;
    private final List<T> content;

    public PaginatedResponse(int currentPage, int totalPages, int pageSize, List<T> content) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.content = content;
    }

    public static <I,O>  PaginatedResponse<O> from(PaginatedResponse<I> input, Function<? super I, ? extends O> mapper) {
        List<O> outputContent = input.getContent().stream().map(mapper).collect(Collectors.toList());
        return new PaginatedResponse<>(input.currentPage, input.totalPages, input.pageSize, outputContent);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getContent() {
        return content;
    }
}
