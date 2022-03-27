package com.durellinux.showcase.organizationservice.resources.units.service;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.TransactionManager;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.ScopedUnitRequest;
import com.durellinux.showcase.organizationservice.resources.units.service.model.Unit;
import com.durellinux.showcase.organizationservice.resources.units.service.model.UnitOrganizationId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UnitServiceTransactional implements IUnitService {
    private final TransactionManager transactionManager;
    private final UnitService unitService;

    @Inject
    public UnitServiceTransactional(TransactionManager transactionManager, UnitService unitService) {
        this.transactionManager = transactionManager;
        this.unitService = unitService;
    }

    @Override
    public Unit create(ScopedUnitRequest request) {
        transactionManager.openSessionTransaction();
        Unit result = unitService.create(request);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public Unit update(UnitOrganizationId id, ScopedUnitRequest request) {
        transactionManager.openSessionTransaction();
        Unit result = unitService.update(id, request);
        transactionManager.closeSessionTransaction();

        return result;
    }

    @Override
    public Unit getById(UnitOrganizationId id) {
        return unitService.getById(id);
    }

    @Override
    public void delete(UnitOrganizationId id) {
        transactionManager.openSessionTransaction();
        unitService.delete(id);
        transactionManager.closeSessionTransaction();
    }

    @Override
    public PaginatedResponse<Unit> list(SearchRequest searchRequest) {
        return unitService.list(searchRequest);
    }
}
