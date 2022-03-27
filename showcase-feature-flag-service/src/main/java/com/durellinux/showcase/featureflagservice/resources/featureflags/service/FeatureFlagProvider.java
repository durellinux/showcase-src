package com.durellinux.showcase.featureflagservice.resources.featureflags.service;

import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FeatureFlagProvider {
    private final Map<String, FeatureFlag> featureFlagMap;

    public FeatureFlagProvider() {
        featureFlagMap = new HashMap<>();

        addFeatureFlag(new FeatureFlag("test", true));
    }

    private void addFeatureFlag(FeatureFlag featureFlag) {
        if (featureFlagMap.containsKey(featureFlag.getName())) {
            throw new IllegalArgumentException("Trying to create already existing feature flag");
        }

        featureFlagMap.put(featureFlag.getName(), featureFlag);
    }

    public boolean hasFeatureFlag(String name) {
        return featureFlagMap.containsKey(name);
    }

    public FeatureFlag getFeatureFlag(String name) {
        if (!hasFeatureFlag(name)) {
            throw new IllegalArgumentException("Feature flag " + name + " does not exist");
        }
        return featureFlagMap.get(name);
    }

    public List<FeatureFlag> getAll() {
        return new ArrayList<>(featureFlagMap.values());
    }

}
