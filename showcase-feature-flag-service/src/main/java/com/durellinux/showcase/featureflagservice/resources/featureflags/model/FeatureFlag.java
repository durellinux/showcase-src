package com.durellinux.showcase.featureflagservice.resources.featureflags.model;

import com.durellinux.showcase.commons.argutils.ArgUtils;

public class FeatureFlag {
    private String name;
    private Boolean defaultValue;

    public FeatureFlag(String name, Boolean defaultValue) {
        ArgUtils.assertNotNull(name);
        ArgUtils.assertNotNull(defaultValue);

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
