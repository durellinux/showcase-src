package com.durellinux.showcase.organizationservice.resources.users.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.TransactionManager;
import com.durellinux.showcase.organizationservice.resources.users.controller.model.UserRequest;
import com.durellinux.showcase.organizationservice.resources.users.service.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class UserServiceTransactional implements IUserService {

    private final UserService userService;
    private final TransactionManager transactionManager;

    @Inject
    public UserServiceTransactional(UserService userService, TransactionManager transactionManager) {
        this.userService = userService;
        this.transactionManager = transactionManager;
    }

    @Override
    public User create(UserRequest request) {
        transactionManager.openSessionTransaction();
        User result = userService.create(request);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public User update(UUID id, UserRequest request) {
        transactionManager.openSessionTransaction();
        User result = userService.update(id, request);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public User getById(UUID id) {
        return userService.getById(id);
    }

    @Override
    public void delete(UUID id) {
        transactionManager.openSessionTransaction();
        userService.delete(id);
        transactionManager.closeSessionTransaction();
    }

    @Override
    public PaginatedResponse<User> list(SearchRequest searchRequest) {
        return userService.list(searchRequest);
    }
}
