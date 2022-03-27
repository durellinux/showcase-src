package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service;

import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagRequest;
import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model.TenantFeatureFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TenantFeatureFlagTransactionService implements ITenantFeatureFlagService {

    ITenantFeatureFlagService featureFlagService;

    @Autowired
    public TenantFeatureFlagTransactionService(TenantFeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TenantFeatureFlag createFeatureFlag(String tenant, TenantFeatureFlagRequest request) {
        return this.featureFlagService.createFeatureFlag(tenant, request);
    }

    @Override
    public TenantFeatureFlag getFeatureFlag(String tenantId, String featureFlagName) {
        return this.featureFlagService.getFeatureFlag(tenantId, featureFlagName);
    }

}
