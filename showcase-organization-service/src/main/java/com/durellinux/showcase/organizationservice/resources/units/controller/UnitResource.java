package com.durellinux.showcase.organizationservice.resources.units.controller;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.ScopedUnitRequest;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.UnitRequest;
import com.durellinux.showcase.organizationservice.resources.units.controller.model.UnitResponse;
import com.durellinux.showcase.organizationservice.resources.units.service.IUnitService;
import com.durellinux.showcase.organizationservice.resources.units.service.UnitServiceTransactional;
import com.durellinux.showcase.organizationservice.resources.units.service.model.Unit;
import com.durellinux.showcase.organizationservice.resources.units.service.model.UnitOrganizationId;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/api/v1/organizations/{organizationId}/units")
public class UnitResource {
    private final IUnitService unitService;

    public UnitResource(UnitServiceTransactional unitService) {
        this.unitService = unitService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UnitResponse getByUnitId(@PathParam(value = "organizationId") UUID organizationId, @PathParam(value = "id") UUID id) {
        Unit unit = unitService.getById(new UnitOrganizationId(organizationId, id));
        return new UnitResponse(unit.getUuid(), unit.getOrganization().getUuid(), unit.getName());
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UnitResponse create(@PathParam(value = "organizationId") UUID organizationId, @Valid UnitRequest unitRequest) {
        Unit unit = unitService.create(new ScopedUnitRequest(organizationId, unitRequest));
        return new UnitResponse(unit.getUuid(), organizationId, unit.getName());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UnitResponse updateUnit(@PathParam(value = "organizationId") UUID organizationId, @PathParam(value = "id") UUID id, @Valid UnitRequest unitRequest) {
        Unit unit = unitService.update(new UnitOrganizationId(organizationId, id), new ScopedUnitRequest(organizationId, unitRequest));
        return new UnitResponse(unit.getUuid(), organizationId, unit.getName());
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUnit(@PathParam(value = "organizationId") UUID organizationId, @PathParam(value = "id") UUID id) {
        unitService.delete(new UnitOrganizationId(organizationId, id));
        return "";
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedResponse<UnitResponse> listUnits(@PathParam(value = "organizationId") UUID organizationId, @QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        PaginatedResponse<Unit> paginatedUnits = unitService.list(new SearchRequest(page, pageSize));
        return PaginatedResponse.from(paginatedUnits, o -> new UnitResponse(o.getUuid(), o.getOrganization().getUuid(), o.getName()));
    }

}
