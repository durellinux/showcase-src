package com.durellinux.showcase.featureflagservice.resources.featureflags.service;

import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureFlagService implements IFeatureFlagService {

    private final FeatureFlagProvider featureFlagProvider;

    @Autowired
    public FeatureFlagService(FeatureFlagProvider featureFlagProvider) {
        this.featureFlagProvider = featureFlagProvider;
    }

    @Override
    public List<FeatureFlag> getAll() {
        return featureFlagProvider.getAll();
    }

    @Override
    public boolean hasFeatureFlag(String name) {
        return featureFlagProvider.hasFeatureFlag(name);
    }

    @Override
    public FeatureFlag getFeatureFlag(String name) {
        return featureFlagProvider.getFeatureFlag(name);
    }

}
