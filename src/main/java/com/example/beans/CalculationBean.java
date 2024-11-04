package com.example.beans;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@SessionScoped
@Named("calculationBean")
public class CalculationBean implements Serializable {

  private double result = 0;

  @Inject
  private double inputValue;

  @PostConstruct
  public void init() {
    this.result = inputValue;
  }

  public double getResult() {
    return result;
  }
  public void add() {
    result += this.inputValue;
  }
  public void substract() {
    result -= this.inputValue;
  }

  public void setInputValue(double inputValue) {
    this.inputValue = inputValue;
  }

  public double getInputValue() {
    return this.inputValue;
  }


}
