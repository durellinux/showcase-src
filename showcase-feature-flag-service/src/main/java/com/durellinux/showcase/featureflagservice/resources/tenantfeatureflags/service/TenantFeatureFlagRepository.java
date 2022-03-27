package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service;

import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model.TenantFeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantFeatureFlagRepository extends JpaRepository<TenantFeatureFlag, TenantFeatureFlag.TenantFeatureFlagId> {
    Optional<TenantFeatureFlag> findById(TenantFeatureFlag.TenantFeatureFlagId id);
}
