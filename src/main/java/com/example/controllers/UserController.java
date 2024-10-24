package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

import com.example.entities.User;
import com.example.services.UserCounter;
import com.example.services.UserService;

@Path("users")
@Controller
@RequestScoped
public class UserController {

  @Inject
  private UserService userService;

  @Inject
  private UserCounter userCounter;

  @Inject
  private Models models;

  @GET
  @View("users.xhtml")
  public void showUsers() {
    List<User> users = userService.findAllUsers();
    int activeUsers = userCounter.getActiveUsers();

    models.put("activeUsers", activeUsers);
    models.put("users", users);
  }
}
