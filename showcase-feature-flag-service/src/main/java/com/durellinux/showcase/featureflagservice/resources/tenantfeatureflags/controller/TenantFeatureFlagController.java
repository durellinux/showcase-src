package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller;


import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagRequest;
import com.durellinux.showcase.featureflagservice.resources.featureflags.controller.FeatureFlagResponse;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.controller.dto.TenantFeatureFlagResponse;
import com.durellinux.showcase.featureflagservice.resources.featureflags.model.FeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model.TenantFeatureFlag;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service.TenantFeatureFlagTransactionService;
import com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.service.ITenantFeatureFlagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/tenant/{tenantId}/featureflags")
public class TenantFeatureFlagController implements ITenantFeatureFlagController {

    private final ITenantFeatureFlagService featureFlagService;

    public TenantFeatureFlagController(TenantFeatureFlagTransactionService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TenantFeatureFlagResponse> create(
            @PathVariable String tenantId,
            @RequestBody @Valid TenantFeatureFlagRequest featureFlagRequest
    ) {
        TenantFeatureFlag tenantFeatureFlag = this.featureFlagService.createFeatureFlag(tenantId, featureFlagRequest);
        return new ResponseEntity<>(new TenantFeatureFlagResponse(tenantFeatureFlag.getTenant(), tenantFeatureFlag.getName(), tenantFeatureFlag.getValue()), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{featureFlagName}", produces = "application/json")
    public ResponseEntity<TenantFeatureFlagResponse> get(String tenantId, String featureFlagName) {
        TenantFeatureFlag tenantFeatureFlag = this.featureFlagService.getFeatureFlag(tenantId, featureFlagName);
        return new ResponseEntity<>(new TenantFeatureFlagResponse(tenantFeatureFlag.getTenant(), tenantFeatureFlag.getName(), tenantFeatureFlag.getValue()), HttpStatus.OK);
    }

}
