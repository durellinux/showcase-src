package com.durellinux.showcase.organizationservice.resources.users.exception;

import com.durellinux.showcase.commons.exceptions.BadRequest;

public class UserAlreadyExistsException extends BadRequest {
    @Override
    public int getCode() {
        return 102001;
    }
}
