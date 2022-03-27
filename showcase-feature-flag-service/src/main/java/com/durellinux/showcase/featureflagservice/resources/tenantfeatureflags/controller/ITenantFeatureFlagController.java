package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller;

import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagRequest;
import com.durellinux.showcase.featureflagservice.resources.featureflags.controller.FeatureFlagResponse;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITenantFeatureFlagController {
    ResponseEntity<TenantFeatureFlagResponse> create(String tenantId, TenantFeatureFlagRequest featureFlagRequest);
    ResponseEntity<TenantFeatureFlagResponse> get(String tenantId, String featureFlagName);
//    ResponseEntity<List<TenantFeatureFlagResponse>> getAllFeatureFlagsForTenant(String tenantId);
//    ResponseEntity<List<String>> getAllTenantsWithFeatureFlagSet(String featureFlagName);
}
