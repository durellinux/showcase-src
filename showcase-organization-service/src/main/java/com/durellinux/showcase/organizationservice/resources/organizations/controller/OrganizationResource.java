package com.durellinux.showcase.organizationservice.resources.organizations.controller;

import com.durellinux.showcase.commons.rest.PaginatedResponse;
import com.durellinux.showcase.commons.rest.SearchRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationResponse;
import com.durellinux.showcase.organizationservice.resources.organizations.service.IOrganizationService;
import com.durellinux.showcase.organizationservice.resources.organizations.service.OrganizationServiceTransactional;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;
import org.jboss.resteasy.reactive.RestResponse;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/organizationsservice/api/v1/organizations")
public class OrganizationResource implements IOrganizationResource {

    private final IOrganizationService organizationService;

    public OrganizationResource(OrganizationServiceTransactional organizationService) {
        this.organizationService = organizationService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public RestResponse<OrganizationResponse> getOrganizationById(@PathParam(value = "id") UUID id) {
        Organization organization = organizationService.getById(id);
        return RestResponse.ResponseBuilder
                .ok(new OrganizationResponse(organization.getUuid(), organization.getName()))
                .build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public RestResponse<OrganizationResponse> createOrganization(@Valid OrganizationRequest organizationRequest) {
        Organization organization = organizationService.create(organizationRequest);
        return RestResponse.ResponseBuilder
                .create(Response.Status.CREATED, new OrganizationResponse(organization.getUuid(), organization.getName()))
                .build();

    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationResponse updateOrganization(@PathParam(value = "id") UUID id, @Valid OrganizationRequest organizationRequest) {
        Organization organization = organizationService.update(id, organizationRequest);
        return new OrganizationResponse(organization.getUuid(), organization.getName());
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String deleteOrganization(@PathParam(value = "id") UUID id) {
        organizationService.delete(id);
        return "";
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedResponse<OrganizationResponse> listOrganizations(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        PaginatedResponse<Organization> paginatedOrganizations = organizationService.list(new SearchRequest(page, pageSize));
        return PaginatedResponse.from(paginatedOrganizations, o -> new OrganizationResponse(o.getUuid(), o.getName()));
    }
}
