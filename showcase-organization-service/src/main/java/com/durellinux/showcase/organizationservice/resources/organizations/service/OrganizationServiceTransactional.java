package com.durellinux.showcase.organizationservice.resources.organizations.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.TransactionManager;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class OrganizationServiceTransactional implements IOrganizationService {

    private final OrganizationService organizationService;
    private final TransactionManager transactionManager;

    public OrganizationServiceTransactional(OrganizationService organizationService, TransactionManager transactionManager) {
        this.organizationService = organizationService;
        this.transactionManager = transactionManager;
    }

    @Override
    public Organization create(OrganizationRequest organizationRequest) {
        transactionManager.openSessionTransaction();
        Organization result = organizationService.create(organizationRequest);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public Organization update(UUID id, OrganizationRequest organizationRequest) {
        transactionManager.openSessionTransaction();
        Organization result = organizationService.update(id, organizationRequest);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public Organization getById(UUID id) {
        return organizationService.getById(id);
    }

    @Override
    public void delete(UUID id) {
        transactionManager.openSessionTransaction();
        organizationService.delete(id);
        transactionManager.closeSessionTransaction();
    }

    @Override
    public PaginatedResponse<Organization> list(SearchRequest searchRequest) {
        return organizationService.list(searchRequest);
    }
}
