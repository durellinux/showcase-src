package com.durellinux.showcase.featureflagservice.resources.featureflags.controller;

import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.featureflags.service.IFeatureFlagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/featureflags")
public class FeatureFlagController implements IFeatureFlagController {

    private final IFeatureFlagService featureFlagService;

    public FeatureFlagController(IFeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<FeatureFlagResponse>> getAll() {
        List<FeatureFlag> featureFlags = this.featureFlagService.getAll();
        List<FeatureFlagResponse> featureFlagResponses = featureFlags.stream().map(ff -> new FeatureFlagResponse(ff.getName(), ff.getDefaultValue())).collect(Collectors.toList());
        return new ResponseEntity<>(featureFlagResponses, HttpStatus.OK);
    }
}
