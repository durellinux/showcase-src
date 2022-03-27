package com.durellinux.showcase.organizationservice.resources.organizations.exception;

import com.durellinux.showcase.commons.exceptions.BadRequest;

public class OrganizationAlreadyExistsException extends BadRequest {
    @Override
    public int getCode() {
        return 101001;
    }
}
