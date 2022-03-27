package com.durellinux.showcase.featureflagservice.resources.featureflags.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFeatureFlagController {
    ResponseEntity<List<FeatureFlagResponse>> getAll();
}
