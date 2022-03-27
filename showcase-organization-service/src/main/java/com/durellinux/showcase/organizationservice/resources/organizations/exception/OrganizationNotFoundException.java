package com.durellinux.showcase.organizationservice.resources.organizations.exception;

import com.durellinux.showcase.commons.exceptions.NotFound;

public class OrganizationNotFoundException extends NotFound {
    @Override
    public int getCode() {
        return 101002;
    }
}
