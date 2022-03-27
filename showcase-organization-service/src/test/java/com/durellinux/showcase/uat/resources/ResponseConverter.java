package com.durellinux.showcase.uat.resources;

import io.restassured.response.Response;
import org.jboss.resteasy.reactive.RestResponse;
import javax.ws.rs.core.Response.Status;

public class ResponseConverter {
    public static <T> RestResponse<T> as(Response response, Class<T> clazz) {
        Status status = Status.fromStatusCode(response.getStatusCode());
        if (status.getFamily().equals(Status.Family.SUCCESSFUL)) {
            return RestResponse.ResponseBuilder.create(status, response.getBody().as(clazz)).build();
        }

        throw new RuntimeException("Endpoint failed"); // TODO: Decode properly
    }
}
