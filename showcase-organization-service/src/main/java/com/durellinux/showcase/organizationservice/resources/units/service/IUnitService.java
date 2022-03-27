package com.durellinux.showcase.organizationservice.resources.units.service;

import com.durellinux.showcase.organizationservice.commons.rest.ICrudService;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.ScopedUnitRequest;
import com.durellinux.showcase.organizationservice.resources.units.service.model.Unit;
import com.durellinux.showcase.organizationservice.resources.units.service.model.UnitOrganizationId;

public interface IUnitService extends ICrudService<Unit, UnitOrganizationId, ScopedUnitRequest> {
}
