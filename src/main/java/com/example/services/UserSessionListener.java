package com.example.services;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {

  @Inject
  private UserCounter userCounter;

  @Override
  public void sessionCreated(HttpSessionEvent se ) {
    userCounter.increment();
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
   userCounter.decrement(); 
  }
}
