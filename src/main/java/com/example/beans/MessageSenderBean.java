package com.example.beans;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;

@Named
@RequestScoped
public class MessageSenderBean {

  @Resource(lookup = "jms/testQueue")
  private Queue queue;

  @Resource
  private ConnectionFactory connectionFactory;

  private String filter;
  private String messageText;

  public void sendMessage() {
    try (JMSContext context = connectionFactory.createContext()) {
      JMSProducer producer = context.createProducer();
      producer.setProperty("filter", filter);
      producer.send(queue, messageText);
    }
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

}
