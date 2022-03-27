package com.durellinux.showcase.organizationservice.resources.users.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.resources.users.controller.model.UserRequest;
import com.durellinux.showcase.organizationservice.resources.users.exception.UserAlreadyExistsException;
import com.durellinux.showcase.organizationservice.resources.users.exception.UserNotFoundException;
import com.durellinux.showcase.organizationservice.resources.users.service.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserService implements IUserService {

    private final UserNeo4JRepository userNeo4JRepository;

    @Inject
    public UserService(UserNeo4JRepository userNeo4JRepository) {
        this.userNeo4JRepository = userNeo4JRepository;
    }

    @Override
    public User create(UserRequest request) {
        if (findUserByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User user = new User(request.getName(), request.getSurname(), request.getEmail());
        return userNeo4JRepository.save(user);
    }

    @Override
    public User update(UUID id, UserRequest request) {
        User user = getById(id);
        user.setName(request.getName());
        user.setSurname(request.getSurname());

        if (!user.getEmail().equals(request.getEmail())) {
            // TODO: mail verification flow
            user.verifyEmail(request.getEmail());
        }

        return userNeo4JRepository.save(user);
    }

    @Override
    public User getById(UUID id) {
        return userNeo4JRepository.findByUuid(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(UUID id) {
        User user = getById(id);
        userNeo4JRepository.delete(user);
    }

    @Override
    public PaginatedResponse<User> list(SearchRequest searchRequest) {
        // TODO: Implement
        return null;
    }

    public Optional<User> findUserByEmail(String email) {
        return userNeo4JRepository.findOneBy("email", email);
    }
}
