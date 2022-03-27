package com.durellinux.showcase.organizationservice.resources.units.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4jLabelProvider;
import com.durellinux.showcase.organizationservice.resources.organizations.service.OrganizationService;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.ScopedUnitRequest;
import com.durellinux.showcase.organizationservice.resources.units.service.model.Unit;
import com.durellinux.showcase.organizationservice.resources.units.service.model.UnitBelongsToOrganization;
import com.durellinux.showcase.organizationservice.resources.units.service.model.UnitOrganizationId;
import org.neo4j.driver.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UnitService implements IUnitService {
    private final UnitNeo4JRepository unitNeo4JRepository;
    private final OrganizationService organizationService;

    @Inject
    public UnitService(UnitNeo4JRepository unitNeo4JRepository, OrganizationService organizationService) {
        this.unitNeo4JRepository = unitNeo4JRepository;
        this.organizationService = organizationService;
    }

    @Override
    public Unit create(ScopedUnitRequest request) {
        Organization organization = organizationService.getById(request.getOrganizationId());
        Unit unit = new Unit(request.getName(), organization);
        return unitNeo4JRepository.save(unit);
    }

    @Override
    public Unit update(UnitOrganizationId id, ScopedUnitRequest request) {
        return null;
    }

    @Override
    public Unit getById(UnitOrganizationId id) {
        String unitLabel = Neo4jLabelProvider.getInstance().getNodeLabel(Unit.class);
        String organizationLabel = Neo4jLabelProvider.getInstance().getNodeLabel(Organization.class);
        String relationLabel = Neo4jLabelProvider.getInstance().getRelationLabel(UnitBelongsToOrganization.class);
        Query query = new Query("MATCH (u:" + unitLabel + " {uuid: '" + id.getUnitId().toString() + "'}) -[r:" + relationLabel + "]-> (o: " + organizationLabel + " {uuid: '" + id.getOrganizationId() + "'}) RETURN u");
        return unitNeo4JRepository.getQueryRunner().runSingleValueQuery(query, "u", Unit.class);
    }

    @Override
    public void delete(UnitOrganizationId id) {
        Unit unit = getById(id);
        unitNeo4JRepository.delete(unit);
    }

    @Override
    public PaginatedResponse<Unit> list(SearchRequest searchRequest) {
        return null;
    }
}
