package com.durellinux.showcase.organizationservice.resources.units.service.model;

import java.util.UUID;

public class UnitOrganizationId {
    private UUID organizationId;
    private UUID unitId;

    public UnitOrganizationId(UUID organizationId, UUID unitId) {
        this.organizationId = organizationId;
        this.unitId = unitId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public UUID getUnitId() {
        return unitId;
    }
}
