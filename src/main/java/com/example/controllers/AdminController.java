package com.example.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@Path("admin")
@RequestScoped
public class AdminController {

    @View("admin.xhtml")
    @GET
    @RolesAllowed("ADMIN")
    public void adminPanel() {
    }
}
