package com.durellinux.showcase.featureflagservice.resources.featureflags.exception;

import com.durellinux.showcase.commons.exceptions.BadRequest;

public class InvalidFeatureFlagException extends BadRequest {
    @Override
    public int getCode() {
        return 1001;
    }
}
