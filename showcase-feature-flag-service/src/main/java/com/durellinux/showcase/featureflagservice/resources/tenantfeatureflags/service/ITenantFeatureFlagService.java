package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service;

import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagRequest;
import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model.TenantFeatureFlag;

import java.util.List;

public interface ITenantFeatureFlagService {
    TenantFeatureFlag createFeatureFlag(String tenant, TenantFeatureFlagRequest request);
    TenantFeatureFlag getFeatureFlag(String tenantId, String featureFlagName);
}
