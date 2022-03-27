package com.durellinux.showcase.featureflagservice.resources.featureflags.controller;

public class FeatureFlagResponse {
    private final String name;
    private final Boolean defaultValue;

    public FeatureFlagResponse(String name, Boolean defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public Boolean getDefaultValue() {
        return defaultValue;
    }
}
