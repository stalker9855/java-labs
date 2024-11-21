package com.example.beans;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;

@Named
@ApplicationScoped
public class MessageReceiverBean {

  @Resource(lookup = "jms/testQueue")
  private Queue queue;

  @Resource
  private ConnectionFactory connectionFactory;

  private String lastMessage = "No notifications yet.";

  private String filter;

  public void receiveMessage() {
    try (JMSContext context = connectionFactory.createContext()) {
      JMSConsumer consumer = context.createConsumer(queue, "filter = '" + filter + "'");
      Message message = consumer.receive(1000);
      if (message instanceof TextMessage) {
        lastMessage = ((TextMessage) message).getText();
      } else {
        lastMessage = "No notifications.";
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  public String getLastMessage() {
    return lastMessage;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

}
