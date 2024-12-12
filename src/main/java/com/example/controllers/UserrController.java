package com.example.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@Path("user")
@RequestScoped
public class UserrController {

    @GET
    @View("user.xhtml")
    @RolesAllowed({"USER","ADMIN"})
    public void  profile() {
    }
}
