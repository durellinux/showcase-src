package com.durellinux.showcase.organizationservice.commons.rest;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;

public interface ICrudService<E, I, R> {
    E create(R request);
    E update(I id, R request);
    E getById(I id);
    void delete(I id);
    PaginatedResponse<E> list(SearchRequest searchRequest);
}
