package com.durellinux.showcase.featureflagservice.resources.featureflags.service;

import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;

import java.util.List;

public interface IFeatureFlagService {
    List<FeatureFlag> getAll();
    boolean hasFeatureFlag(String name);
    FeatureFlag getFeatureFlag(String name);
}
