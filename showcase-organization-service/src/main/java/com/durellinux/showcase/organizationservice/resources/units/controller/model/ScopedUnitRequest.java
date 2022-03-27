package com.durellinux.showcase.organizationservice.resources.units.controller.model;

import java.util.UUID;

public class ScopedUnitRequest extends UnitRequest {
    private final UUID organizationId;

    public ScopedUnitRequest(UUID organizationId, UnitRequest unitRequest) {
        super(unitRequest.getName());
        this.organizationId = organizationId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }
}
