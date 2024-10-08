package com.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloBean {
    private String greeting;
    private String name;

    public String getGreeting() {
        return greeting;
    }

    public String getName() {
        return name;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        if (name != null && !name.isEmpty()) {
            this.greeting = "Hi, " + this.name + "!";
        } else {
            this.greeting = "Hi, Stranger!";
        }
    }
}
