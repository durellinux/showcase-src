package com.durellinux.showcase.organizationservice.resources.organizations.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.exception.OrganizationAlreadyExistsException;
import com.durellinux.showcase.organizationservice.resources.organizations.exception.OrganizationNotFoundException;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class OrganizationService implements IOrganizationService {
    private final OrganizationNeo4JRepository organizationNeo4JRepository;

    @Inject
    public OrganizationService(OrganizationNeo4JRepository organizationNeo4JRepository) {
        this.organizationNeo4JRepository = organizationNeo4JRepository;
    }

    @Override
    public Organization create(OrganizationRequest organizationRequest) {
        if (findOrganizationByName(organizationRequest.getName()).isPresent()) {
            throw new OrganizationAlreadyExistsException();
        }

        Organization organization = new Organization(organizationRequest.getName());
        return organizationNeo4JRepository.save(organization);
    }

    @Override
    public Organization update(UUID id, OrganizationRequest organizationRequest) {
        Organization organization = getById(id);
        Optional<Organization> organizationWithSameName = findOrganizationByName(organization.getName());

        if (organizationWithSameName.isPresent() && !organization.getUuid().equals(organizationWithSameName.get().getUuid())) {
            throw new OrganizationAlreadyExistsException();
        }

        organization.setName(organizationRequest.getName());

        return organizationNeo4JRepository.save(organization);
    }

    @Override
    public Organization getById(UUID id) {
        return organizationNeo4JRepository.findByUuid(id)
                .orElseThrow(OrganizationNotFoundException::new);
    }

    @Override
    public void delete(UUID id) {
        Organization organization = getById(id);
        organizationNeo4JRepository.delete(organization);
    }

    @Override
    public PaginatedResponse<Organization> list(SearchRequest searchRequest) {
        // TODO: Continue
        return null;
    }

    private Optional<Organization> findOrganizationByName(String name) {
        return organizationNeo4JRepository.findOneBy("name", name);
    }

}
