package com.durellinux.showcase.organizationservice.resources.organizations.controller.model;

import com.durellinux.showcase.commons.argutils.ArgUtils;
import com.durellinux.showcase.commons.pojo.AbstractSimplePojo;

import java.util.UUID;

public class OrganizationResponse extends AbstractSimplePojo {
    private final UUID id;
    private final String name;

    public OrganizationResponse(UUID id, String name) {
        ArgUtils.assertNotNull(id);
        ArgUtils.assertNotNull(name);
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
