package com.durellinux.showcase.organizationservice.resources.users.controller;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.resources.users.controller.model.UserRequest;
import com.durellinux.showcase.organizationservice.resources.users.controller.model.UserResponse;
import com.durellinux.showcase.organizationservice.resources.users.service.IUserService;
import com.durellinux.showcase.organizationservice.resources.users.service.UserServiceTransactional;
import com.durellinux.showcase.organizationservice.resources.users.service.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/api/v1/users")
public class UserResource {

    private final IUserService userService;

    @Inject
    public UserResource(UserServiceTransactional userService) {
        this.userService = userService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse getUserById(@PathParam(value = "id") UUID id) {
        User user = userService.getById(id);
        return new UserResponse(user.getUuid(), user.getName(), user.getSurname());
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse create(@Valid UserRequest userRequest) {
        User user = userService.create(userRequest);
        return new UserResponse(user.getUuid(), user.getName(), user.getSurname());
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse updateUser(@PathParam(value = "id") UUID id, @Valid UserRequest userRequest) {
        User user = userService.update(id, userRequest);
        return new UserResponse(user.getUuid(), user.getName(), user.getSurname());
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam(value = "id") UUID id) {
        userService.delete(id);
        return "";
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedResponse<UserResponse> listUsers(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        PaginatedResponse<User> paginatedUsers = userService.list(new SearchRequest(page, pageSize));
        return PaginatedResponse.from(paginatedUsers, o -> new UserResponse(o.getUuid(), o.getName(), o.getSurname()));
    }
}
