package com.durellinux.showcase.commons.rest;

public class SearchRequest implements IPaginatedRequest {
    private int page;
    private int pageSize;

    public SearchRequest() {
    }

    public SearchRequest(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }
}
