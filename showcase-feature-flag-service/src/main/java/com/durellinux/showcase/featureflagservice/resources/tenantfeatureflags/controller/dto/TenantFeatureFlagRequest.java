package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto;

public class TenantFeatureFlagRequest {
    private String name;
    private Boolean value;

    protected TenantFeatureFlagRequest() {
    }

    public TenantFeatureFlagRequest(String name, Boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Boolean getValue() {
        return value;
    }
}
