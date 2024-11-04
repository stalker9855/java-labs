package com.example.beans;

import java.io.Serializable;
import java.util.Set;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named("metadataBean")
public class MetadataBean implements Serializable {
  @Inject
  private BeanManager beanManager;

  private Set<Bean<?>> beans;

  @PostConstruct
  public void init() {
    beans = beanManager.getBeans(Object.class);
  }

  public Set<Bean<?>> getBeans() {
    return beans;
  }
}
