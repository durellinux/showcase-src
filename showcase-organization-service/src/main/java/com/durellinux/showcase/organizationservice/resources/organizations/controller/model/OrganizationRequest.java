package com.durellinux.showcase.organizationservice.resources.organizations.controller.model;

import com.durellinux.showcase.commons.pojo.AbstractSimplePojo;

import javax.validation.constraints.NotBlank;

public class OrganizationRequest extends AbstractSimplePojo {
    @NotBlank
    private String name;

    protected OrganizationRequest() {
    }

    public OrganizationRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
