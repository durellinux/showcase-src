package com.durellinux.showcase.organizationservice.resources.units.controller.model;

import java.util.UUID;

public class UnitResponse {
    private final UUID id;
    private final UUID organizationId;
    private final String name;

    public UnitResponse(UUID id, UUID organizationId, String name) {
        this.id = id;
        this.organizationId = organizationId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }
}
