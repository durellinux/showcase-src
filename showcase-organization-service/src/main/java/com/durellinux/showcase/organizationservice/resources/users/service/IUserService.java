package com.durellinux.showcase.organizationservice.resources.users.service;

import com.durellinux.showcase.organizationservice.commons.rest.ICrudService;
import com.durellinux.showcase.organizationservice.resources.users.controller.model.UserRequest;
import com.durellinux.showcase.organizationservice.resources.users.service.model.User;

import java.util.UUID;

public interface IUserService extends ICrudService<User, UUID, UserRequest> {
}
