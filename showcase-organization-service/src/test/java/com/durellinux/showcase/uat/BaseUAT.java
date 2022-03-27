package com.durellinux.showcase.uat;

import com.durellinux.showcase.uat.resources.ExampleTestResource;
import com.durellinux.showcase.uat.resources.OrganizationTestResource;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseUAT {

    protected final RequestSpecification testServer;
    protected final OrganizationTestResource organizationTestResource;
    protected final ExampleTestResource exampleTestResource;

    public BaseUAT() {
        testServer = given();
        testServer.port(8081);
        organizationTestResource = new OrganizationTestResource(testServer);
        exampleTestResource = new ExampleTestResource(testServer);
    }
}
