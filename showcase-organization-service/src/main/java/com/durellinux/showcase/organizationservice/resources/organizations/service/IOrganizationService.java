package com.durellinux.showcase.organizationservice.resources.organizations.service;

import com.durellinux.showcase.organizationservice.commons.rest.ICrudService;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

import java.util.UUID;

public interface IOrganizationService extends ICrudService<Organization, UUID, OrganizationRequest> {
}
