package com.durellinux.showcase.organizationservice.resources.users.exception;

import com.durellinux.showcase.commons.exceptions.NotFound;

public class UserNotFoundException extends NotFound {
    @Override
    public int getCode() {
        return 102002;
    }
}
