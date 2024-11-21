package com.example.beans;


import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class WebSocketEndpoint {

  @OnMessage
  public String onMessage(String message, Session session) {
    System.out.println("Recieved message: " + message);
    return "Server echo: " + message;
  }
}
