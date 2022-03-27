package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service;

import com.durellinux.showcase.featureflagservice.resources.featureflags.service.IFeatureFlagService;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagRequest;
import com.durellinux.showcase.featureflagservice.resources.featureflags.exception.InvalidFeatureFlagException;
import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model.TenantFeatureFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantFeatureFlagService implements ITenantFeatureFlagService {

    private final IFeatureFlagService featureFlagService;
    private final TenantFeatureFlagRepository tenantFeatureFlagRepository;

    @Autowired
    public TenantFeatureFlagService(IFeatureFlagService featureFlagService, TenantFeatureFlagRepository tenantFeatureFlagRepository) {
        this.featureFlagService = featureFlagService;
        this.tenantFeatureFlagRepository = tenantFeatureFlagRepository;
    }

    @Override
    public TenantFeatureFlag createFeatureFlag(String tenant, TenantFeatureFlagRequest request) {
        if (!featureFlagService.hasFeatureFlag(request.getName())) {
            throw new InvalidFeatureFlagException();
        }

        TenantFeatureFlag tenantFeatureFlag = new TenantFeatureFlag(tenant, request.getName(), request.getValue());
        return tenantFeatureFlagRepository.saveAndFlush(tenantFeatureFlag);
    }

    @Override
    public TenantFeatureFlag getFeatureFlag(String tenantId, String featureFlagName) {
        if (!featureFlagService.hasFeatureFlag(featureFlagName)) {
            throw new InvalidFeatureFlagException();
        }

        Optional<TenantFeatureFlag> optionalFeatureFlag = tenantFeatureFlagRepository.findById(new TenantFeatureFlag.TenantFeatureFlagId(tenantId, featureFlagName));

        if (optionalFeatureFlag.isPresent()) {
            return optionalFeatureFlag.get();
        } else {
            FeatureFlag ff = featureFlagService.getFeatureFlag(featureFlagName);
            return new TenantFeatureFlag(tenantId, ff.getName(), ff.getDefaultValue());
        }
    }

}
