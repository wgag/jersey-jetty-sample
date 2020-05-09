package com.example.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloResource {
    @GET
    public String hello(@QueryParam("name") @DefaultValue("world") String name) {
        return "Hello, " + name + "!";
    }
}
