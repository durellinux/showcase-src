package com.durellinux.showcase.uat;

import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationRequest;
import com.durellinux.showcase.organizationservice.resources.organizations.controller.model.OrganizationResponse;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@QuarkusTest
class OrganizationUatTests extends BaseUAT {

    @Test
    void canCreateAndGetOrganization() {
        // When creating organization
        OrganizationRequest organizationToCreate = new OrganizationRequest(UUID.randomUUID().toString());
        OrganizationResponse organizationCreated = organizationTestResource.createOrganization(organizationToCreate).getEntity();

        // Then organization is created
        Assertions.assertThat(organizationCreated.getName()).isEqualTo(organizationToCreate.getName());
        Assertions.assertThat(organizationCreated.getId()).isNotNull();

        // And can be fetched
        OrganizationResponse organizationRead = organizationTestResource.getOrganizationById(organizationCreated.getId()).getEntity();
        Assertions.assertThat(organizationRead).usingRecursiveComparison().isEqualTo(organizationCreated); // TODO: Provide POJO equality
    }

    public void gettingNonExistingOrganizationError() {
        // When getting an organization that does not exists

        // Then not found error is returned

    }

    public void canDeleteExistingOrganization() {
        // Given an existing organization

        // When deleting it

        // Then the organization is deleted

        // And cannot be fetched anymore

    }

    public void canDeleteNonExistingOrganization() {
        // When deleting a non-existing organization

        // Then the operation succeeds

    }
}
