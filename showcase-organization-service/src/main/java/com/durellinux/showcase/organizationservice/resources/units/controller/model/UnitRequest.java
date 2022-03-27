package com.durellinux.showcase.organizationservice.resources.units.controller.model;

import javax.validation.constraints.NotBlank;

public class UnitRequest {
    @NotBlank
    private String name;

    protected UnitRequest() {
        // Empty constructor for serialization
    }

    public UnitRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
