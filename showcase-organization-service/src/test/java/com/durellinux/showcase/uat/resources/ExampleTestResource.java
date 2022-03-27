package com.durellinux.showcase.uat.resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExampleTestResource {
    private final RequestSpecification testServer;

    public ExampleTestResource(RequestSpecification testServer) {
        this.testServer = testServer;
    }

    public String hello() {
        Response response = testServer.when().get("/hello");
        return response.getBody().asString();
    }
}
