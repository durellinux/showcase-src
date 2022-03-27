package com.durellinux.showcase.uat.resources;

import com.durellinux.showcase.organizationservice.resources.organizations.controller.IOrganizationResource;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.vertx.core.json.Json;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.UUID;

public class OrganizationTestResource implements IOrganizationResource {
    private static final String resourceEndpoint = "/api/v1/organizations";

    private final RequestSpecification testServer;

    public OrganizationTestResource(RequestSpecification testServer) {
        this.testServer = testServer;
    }

    @Override
    public RestResponse<OrganizationResponse> getOrganizationById(UUID id) {
        Response response = testServer.get(resourceEndpoint + "/" + id.toString());
        return ResponseConverter.as(response, OrganizationResponse.class);
    }

    @Override
    public RestResponse<OrganizationResponse> createOrganization(OrganizationRequest organizationRequest) {
        String body = Json.encode(organizationRequest);
        Response response = testServer
                .when()
                .contentType("application/json")
                .body(body)
                .post(resourceEndpoint);

        return ResponseConverter.as(response, OrganizationResponse.class);
    }

    @Override
    public String deleteOrganization(UUID id) {
        Response response = testServer
                .when()
                .post(resourceEndpoint + "/" + id.toString());

        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        }

        throw new RuntimeException("Endpoint failed"); // TODO: Decode properly
    }
}
