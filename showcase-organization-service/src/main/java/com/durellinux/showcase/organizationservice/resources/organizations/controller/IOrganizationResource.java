package com.durellinux.showcase.organizationservice.resources.organizations.controller;

import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationResponse;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.UUID;

public interface IOrganizationResource {
    RestResponse<OrganizationResponse> getOrganizationById(UUID id);
    RestResponse<OrganizationResponse> createOrganization(OrganizationRequest organizationRequest);
    String deleteOrganization(UUID id);
}
