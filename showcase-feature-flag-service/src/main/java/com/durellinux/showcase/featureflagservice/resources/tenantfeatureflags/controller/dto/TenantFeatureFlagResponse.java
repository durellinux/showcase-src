package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto;

import com.durellinux.showcase.commons.argutils.ArgUtils;

public class TenantFeatureFlagResponse {
    private final String tenant;
    private final String name;
    private final Boolean value;

    public TenantFeatureFlagResponse(String tenant, String name, Boolean value) {
        ArgUtils.assertNotNull(tenant);
        ArgUtils.assertNotNull(name);
        ArgUtils.assertNotNull(value);

        this.tenant = tenant;
        this.name = name;
        this.value = value;
    }

    public String getTenant() {
        return tenant;
    }

    public String getName() {
        return name;
    }

    public Boolean getValue() {
        return value;
    }
}
