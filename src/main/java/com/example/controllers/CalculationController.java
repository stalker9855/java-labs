package com.example.controllers;

import com.example.beans.CalculationBean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.mvc.View;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("calculation")
@Controller
@RequestScoped
public class CalculationController {

  private static final double INPUT_VALUE = 15.0;

  @Inject
  private CalculationBean calculationBean;

  @Inject
  private Models models;

  @Produces
  public double getInputValue() {
    return INPUT_VALUE;
  }

  @POST
  @Path("/add")
  public Response addNumber(@FormParam("number") double number) {
    calculationBean.setInputValue(number);
    calculationBean.add();
    return Response.ok("redirect:calculation").build();
  }

  @POST
  @Path("/subtract")
  public Response subtractNumber(@FormParam("number") double number) {
    calculationBean.setInputValue(number);
    calculationBean.substract();
    return Response.ok("redirect:calculation").build();
  }

  @GET
  @View("calculation.xhtml")
  public void showCalculation() {
    models.put("currentResult", calculationBean.getResult());
  }

}
